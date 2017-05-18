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

        it("should construct css with a nested element") {
            val expectedCss = (
                    ".social-links-viewpart{position:relative;}" +
                    ".social-links-viewpart .social-links .tooltip .tooltip-inner{max-width:300px;}"
                    )

            val actualCss = css(".social-links-viewpart") {
                this position Position.Relative // or position(Position.Relative)

                css(".social-links") {
                    css(".tooltip") {
                        css(".tooltip-inner") {
                            this maxWidth 300.px() // or maxWidth(300.px())
                        }
                    }
                }
            }

            assertEquals(expectedCss, actualCss)
        }

        it("should construct css with nested elements and advanced properties") {
            val expectedCss = (
                    ".social-links-viewpart{position:relative;}" +
                    ".social-links-viewpart .social-links{position:absolute;bottom:20px;right:20px;background-color:'#3233aa33';border-radius:3px;height:27px;}" +
                    ".social-links-viewpart .social-links .tooltip .tooltip-inner{max-width:300px;}"
                    )

            val miniGutter = 3.px()
            val iconSize = 24.px()
            val gutter = 20.px()

            val actualCss = css(".social-links-viewpart") {
                this position Position.Relative

                css(".social-links") {
                    this position Position.Absolute
                    this bottom gutter
                    this right gutter
                    this backgroundColor rgba(51, 170, 51, 50)
                    this borderRadius 3.px()
                    this height iconSize + miniGutter

                    css(".tooltip") {
                        css(".tooltip-inner") {
                            this maxWidth 300.px()
                        }
                    }
                }
            }

            assertEquals(expectedCss, actualCss)
        }
    }
})