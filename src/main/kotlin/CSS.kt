import kotlin.collections.HashMap

/**
 * Created by eugene.yamenko on 17/05/2017.
 */

class CSS(val name: String) {
    val properties = HashMap<String, String>()
    val elements = ArrayList<CSS>()

    infix fun position(position: Position) {
        properties["position"] = position.toString()
    }

    infix fun maxWidth(px: PX) {
        properties["max-width"] = px.toString()
    }

    fun css(name: String, init: CSS.() -> Unit) {
        val css = CSS(name)

        css.init()

        elements.add(css)
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()

        if (properties.isNotEmpty())
            stringBuilder.append(name + "{" + properties.map { "${it.key}:${it.value};" }.joinToString("") + "}")

        if (elements.isNotEmpty())
            elements.forEach { stringBuilder.append(name + " " + it.toString()) }

        return stringBuilder.toString()
    }
}

fun css(name: String, init: CSS.() -> Unit): String {
    val css = CSS(name)

    css.init()

    return css.toString()
}