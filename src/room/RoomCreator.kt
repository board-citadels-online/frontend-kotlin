package room

import kotlinx.html.InputType
import kotlinx.html.id
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onSubmitFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.*
import react.dom.button
import react.dom.div
import react.dom.form
import react.dom.input

interface RoomCreatorProps : RProps {
    var onCreate: (String) -> Unit
}

interface RoomCreatorState : RState {
    var name: String
}

class RoomCreator(props: RoomCreatorProps) : RComponent<RoomCreatorProps, RoomCreatorState>(props) {

    override fun RoomCreatorState.init(props: RoomCreatorProps) {
        name = ""
    }

    override fun RBuilder.render() {
        form(classes = "form-inline") {
            attrs {
                onSubmitFunction = this@RoomCreator::handleSubmit
            }

            div("form-group") {
                input(classes = "form-control", type = InputType.text) {
                    attrs {
                        id = "room-name"
                        placeholder = "Room Name"
                        autoComplete = false
                        //value =

                        onChangeFunction = this@RoomCreator::handleChange
                    }
                }
            }

            button(classes = "btn btn-primary") {
                +"Create Room"
            }
        }
    }

    private fun handleChange(event: Event) {
        val target = event.target as HTMLInputElement

        setState {
            name = target.value
        }
    }

    private fun handleSubmit(event: Event) {
        val name = state.name

        if(!name.isEmpty()) {
            props.onCreate(name)
            setState {
                this.name = ""
            }
        }

        event.preventDefault()
    }

}

fun RBuilder.roomCreator(onCreate: (String) -> Unit = {}) = child(RoomCreator::class) {
    attrs {
        this.onCreate = onCreate
    }
}