/**
 * Created by eugene.yamenko on 17/05/2017.
 */

class CssElement(val name: String, val parentName: String? = null) {
    val properties = ArrayList<CssProperty>()
    val elements = ArrayList<CssElement>()

    infix fun position(position: Position) {
        properties.add(CssProperty("position", position))
    }

    infix fun maxWidth(px: PX) {
        properties.add(CssProperty("max-width", px))
    }

    infix fun bottom(px: PX) {
        properties.add(CssProperty("bottom", px))
    }

    infix fun right(px: PX) {
        properties.add(CssProperty("right", px))
    }

    infix fun backgroundColor(hex: String) {
        properties.add(CssProperty("background-color", hex))
    }

    infix fun borderRadius(px: PX) {
        properties.add(CssProperty("border-radius", px))
    }

    infix fun height(px: PX) {
        properties.add(CssProperty("height", px))
    }

    fun css(name: String, init: CssElement.() -> Unit) {
        val css = CssElement(name, getCompleteName())

        css.init()

        elements.add(css)
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()

        if (properties.isNotEmpty())
            stringBuilder.append("${getCompleteName()}{${properties.joinToString("")}}")

        if (elements.isNotEmpty())
            stringBuilder.append(elements.joinToString(""))

        return stringBuilder.toString()
    }

    private fun getCompleteName() = if (parentName != null) "$parentName $name" else name
}

fun css(name: String, init: CssElement.() -> Unit): String {
    val css = CssElement(name)

    css.init()

    return css.toString()
}

fun rgba(red: Int, green: Int, blue: Int, alpha: Int): String {
    return String.format("'#%02x%02x%02x%02x'", alpha, red, green, blue)
}