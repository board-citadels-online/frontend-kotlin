package navbar

import kotlinx.html.A
import react.RBuilder
import react.dom.RDOMBuilder
import react.dom.a
import react.dom.div
import react.dom.nav

fun RBuilder.navbar() {
    nav("navbar navbar-expand-lg navbar-dark bg-dark") {
        a(classes = "navbar-brand", href = "/") {
            +"Citadels Online"
            //TODO logo
        }

        div("navbar-nav") {
            navItem(href = "/", active = true) {
                +"Home"
            }
            navItem(href = "#") {
                +"Features"
            }
            navItem(href = "#") {
                +"Pricing"
            }
            navItem(href = "#", disabled = true) {
                +"Disabled"
            }
        }
    }
}

private fun RBuilder.navItem(href: String = "", active: Boolean = false, disabled: Boolean = false, block: RDOMBuilder<A>.() -> Unit) {
    val activeClass = if (active) "active" else ""
    val disabledClass = if (disabled) "disabled" else ""
    val classes = "navItem nav-link $activeClass $disabledClass"

    a(classes = classes, href = href, block = block)
}
