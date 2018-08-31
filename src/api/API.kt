package api

typealias Handler<T> = (T) -> Unit

interface API {
    val roomAPI: RoomAPI
}

class AxiosAPI : API {
    override val roomAPI: RoomAPI = AxiosRoomAPI()

}