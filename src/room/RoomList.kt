package room

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*

interface RoomListProps : RProps {
    var rooms: List<Room>
}

class RoomList(props: RoomListProps) : RComponent<RoomListProps, RState>(props) {
    override fun RBuilder.render() {
        val rooms = props.rooms

        table("table table-hover table-condensed") {
            thead {
                tr {
                    th { +"Name" }
                    th { +"Players" }
                    th { +"Slots" }
                }
            }

            tbody {
                rooms.forEach { room ->
                    tr {
                        td { +room.name }
                        td {}
                        td { +"${room.slots.free} / ${room.slots.total}" }
                    }
                }
            }
        }
    }
}

fun RBuilder.roomList(rooms: List<Room>) = child(RoomList::class) {
    attrs.rooms = rooms
}