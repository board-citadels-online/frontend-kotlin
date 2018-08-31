package index

import api.AxiosAPI
import app.app
import kotlinext.js.require
import react.dom.render
import kotlin.browser.document

fun main(args: Array<String>) {
    require("bootstrap/dist/css/bootstrap.css")
    require("bootstrap/dist/js/bootstrap.bundle")

    val rootDiv = document.getElementById("root")

    render(rootDiv) {
        app(api = AxiosAPI())
    }
}
