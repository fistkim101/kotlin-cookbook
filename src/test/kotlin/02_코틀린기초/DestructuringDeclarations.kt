package `02_코틀린기초`

import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

@DisplayName("코틀린에서 제공해주는 기본 DTO 활용 및 구조분해할당")
class DestructuringDeclarations : FunSpec({

    test("Pair") {
        val age = 20
        val name = "JK"
        val userDto = Pair<Int, String>(age, name)

        val (userAge, userName) = userDto
        userAge shouldBe age
        userName shouldBe name
    }

    test("Triple") {
        val age = 20
        val name = "JK"
        val job = "developer"
        val userDto = Triple<Int, String, String>(age, name, job)

        val (userAge, userName, userJob) = userDto
        userAge shouldBe age
        userName shouldBe name
        userJob shouldBe job
    }

})