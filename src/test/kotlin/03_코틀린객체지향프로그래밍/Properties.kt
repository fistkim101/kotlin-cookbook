package `03_코틀린객체지향프로그래밍`

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Properties : FunSpec({
    test("커스텀 getter, setter") {
        val user = User(name = "name", age = 20)
        user.isAdult shouldBe true

        user.job shouldBe ""
        user.job = "job"
        user.job shouldBe "jobAdded"
    }

    test("생성자와 property vs parameter") {
        val age = StudentWithAge(name = "name", age = 10)
        age.javaClass.declaredFields.forEach {
            println(it.name)
        }
        age::class.java.declaredFields.size shouldBe 2

        val noAge = StudentWithoutAge(name = "name", age = 10)
        noAge::class.java.declaredFields.forEach {
            println(it.name)
        }
        noAge::class.java.declaredFields.size shouldBe 1
    }
})

class User(val name: String, var age: Int) {

    val isAdult: Boolean
        get() = age > 19

    var job: String = ""
        set(value) {
            field = value + "Added"
        }
}

class StudentWithAge(val name: String, val age: Int)
class StudentWithoutAge(val name: String, age: Int)
