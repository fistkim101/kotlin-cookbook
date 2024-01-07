package `02_코틀린기초`

import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

@DisplayName("Nullable")
class Nullable : FunSpec({

    test("엘비스의 리턴값은 null") {
        val first: String? = null
        val second: String? = "second"
        val third: String? = null

        val result01 = first ?: second ?: third
        result01 shouldBe second

        val result02 = first ?: third
        result02 shouldBe null
    }

})