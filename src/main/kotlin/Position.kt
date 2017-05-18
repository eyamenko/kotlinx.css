/**
 * Created by eugene.yamenko on 17/05/2017.
 */

enum class Position {
    Relative {
        override fun toString() = "relative"
    },

    Absolute {
        override fun toString() = "absolute"
    }
}