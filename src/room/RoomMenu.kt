package room

import api.RoomAPI
import react.*
import react.dom.div

interface RoomMenuProps : RProps {
    var roomAPI: RoomAPI
}

interface RoomMenuState : RState {
    var rooms: List<Room>
}

class RoomMenu(props: RoomMenuProps) : RComponent<RoomMenuProps, RoomMenuState>(props) {

    override fun RoomMenuState.init(props: RoomMenuProps) {
        rooms = emptyList()
    }

    override fun componentDidMount() {
        this.props.roomAPI.findAll { rooms ->
            setState {
                this.rooms = rooms
            }
        }
    }

    override fun RBuilder.render() {
        div {
            roomList(state.rooms)
            roomCreator(onCreate = { console.log(it) })
        }
    }
}

fun RBuilder.roomMenu(roomAPI: RoomAPI) = child(RoomMenu::class) {
    attrs {
        this.roomAPI = roomAPI
    }
}

