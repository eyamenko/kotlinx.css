import kotlin.collections.HashMap

/**
 * Created by eugene.yamenko on 17/05/2017.
 */

class CSS(val name: String) {
    val properties = HashMap<String, String>()

    infix fun position(position: Position) {
        properties["position"] = position.toString()
    }

    override fun toString(): String {
        return name + "{" + properties.map { "${it.key}:${it.value};" }.joinToString("") + "}"
    }
}

fun css(name: String, init: CSS.() -> Unit): String {
    val css = CSS(name)

    css.init()

    return css.toString()
}