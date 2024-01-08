package `04_함수형프로그래밍`

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Lambda : FunSpec({

    // cf. Trailing Lambda
    test("fold") {
        val numbers = listOf(1, 2, 3, 4)
        val accumulate: (Int, Int) -> Int = { acc, number -> acc + number }
//        val sum = numbers.fold(0) { acc, number -> acc + number }
        val sum = numbers.fold(0, accumulate)
        sum shouldBe (1 + 2 + 3 + 4)
    }

    test("reduce") {
        val numbers = listOf(1, 2, 3, 4)
        val sum = numbers.reduce { acc, number -> acc + number }
        sum shouldBe (1 + 2 + 3 + 4)
    }

})