/**
 * Created by eugene.yamenko on 18/05/2017.
 */

data class CssProperty(val name: String, val value: Any) {
    override fun toString(): String {
        return "$name:$value;"
    }
}