package `05_컬렉션`

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Collection : FunSpec({

    test("arrayOf, withIndex") {
        val strings = arrayOf("kim", "park", "choi")
        for ((index, str) in strings.withIndex()) {
            str shouldBe strings[index]
        }
    }

    test("listOf/setOf/mapOf vs mutableListOf, mutableSetOf, mutableMapOf") {
        // 생각없이 나중에 불편하다고 냅다 mutable 만들지 말자
        // 무조건 가능하다면 불변의 장점을 누리자
    }

    // cf. 불변에 대해서 항상 민감해야한다(= 객체가 변할 가능성이 있는 가에 대해서 민감해야한다)
    test("읽기전용 뷰 생성하기 toList, toMap, toSet") {
        val numbers = mutableListOf(1, 2, 3, 4, 5)
        val readOnlyNumbers = numbers.toList() // 참고: this.toMutableList().optimizeReadOnlyList()
        (numbers.hashCode() == readOnlyNumbers.hashCode()) shouldBe true
        (numbers === readOnlyNumbers) shouldBe false
    }

    // array to map
    test("associate, associateWith") {
        val keys = listOf(1, 2, 3)
        val pairs = keys.associate { key -> key to key * 10 }
        val pairMap = keys.associateWith { key -> key * 10 }
        pairs shouldBe pairMap
    }

    test("ifEmpty") {
        val numbers = listOf<Int>()
        val sum = numbers
            .ifEmpty { listOf(1, 2, 3, 4) }
            .fold(0) { acc, element -> acc + element }
        sum shouldBe (1 + 2 + 3 + 4)
    }

})