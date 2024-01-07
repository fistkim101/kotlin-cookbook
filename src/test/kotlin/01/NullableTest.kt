package `01`

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class NullableTest : FunSpec({

    test("nullable") {
        val first: String? = null
        val second: String? = "second"
        val third: String? = null

        val result = first ?: second ?: third
        result shouldBe second
    }

})