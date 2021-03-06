/**
 * Created by eugene.yamenko on 18/05/2017.
 */

class PX(val px: Int) {
    infix operator fun plus(another: PX): PX {
        return PX(px + another.px)
    }

    override fun toString(): String {
        return px.toString() + "px"
    }
}

fun Int.px(): PX {
    return PX(this)
}