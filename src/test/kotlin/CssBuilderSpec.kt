import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

/**
 * Created by eugene.yamenko on 17/05/2017.
 */

object CssBuilderSpec : Spek({
    given("a css builder") {
        it("should construct a simple css") {
            val expectedCss = ".social-links-viewpart{position:relative;}"

            val actualCss = css(".social-links-viewpart") {
                this position Position.Relative // or position(Position.Relative)
            }

            assertEquals(expectedCss, actualCss)
        }
    }
})