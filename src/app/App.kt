package app

import api.API
import navbar.navbar
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import room.roomMenu

interface AppProps : RProps {
    var api: API
}

class App(props: AppProps) : RComponent<AppProps, RState>(props) {
    override fun RBuilder.render() {
        div {
            navbar()
            div("container") {
                roomMenu(props.api.roomAPI)
            }
        }
    }
}

fun RBuilder.app(api: API) = child(App::class) {
    attrs {
        this.api = api
    }
}