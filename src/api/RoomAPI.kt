package api

import common.Axios
import room.Room

data class RoomCreationRequest(val name: String)

interface RoomAPI {
    fun findAll(handler: Handler<List<Room>>)

    fun findOne(id: String, handler: Handler<Room>)

    fun create(request: RoomCreationRequest, handler: Handler<Room>)
}

class AxiosRoomAPI : RoomAPI {
    override fun findAll(handler: Handler<List<Room>>) {
        Axios.get<Array<Room>>(url = "/api/room")
                .then { response ->
                    handler.invoke(response.data.toList())
                }
    }

    override fun findOne(id: String, handler: Handler<Room>) {
        Axios.get<Room>(url = "/api/room/$id")
                .then { response ->
                    handler.invoke(response.data)
                }
    }

    override fun create(request: RoomCreationRequest, handler: Handler<Room>) {
        Axios.post<Room>(url = "/api/room", data = request)
                .then { response ->
                    handler.invoke(response.data)
                }
    }

}