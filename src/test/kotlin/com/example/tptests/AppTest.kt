package com.example.tptests

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class AppTest : FunSpec({
    test("put letter 'A' and number '2' should returns letter 'C'") {
        // Arrange
        val letter = 'A'
        val number = 2
        val cesar = CesarCypher()

        // Act
        val res = cesar.cypher(letter = letter, shift = number)

        // Assert
        res shouldBe 'C'
    }
    test("put letter 'a' should return an error") {
        // Arrange
        val letter = 'a'
        val number = 7
        val cesar = CesarCypher()

        // Act
        fun act() = cesar.cypher(letter = letter, shift = number)

        // Assert
        val exception = shouldThrow<IllegalArgumentException> {
            act()
        }
        exception.message shouldBe "Letter must be uppercase"
    }
})