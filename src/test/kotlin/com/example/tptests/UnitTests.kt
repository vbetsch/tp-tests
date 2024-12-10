package com.example.tptests

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class UnitTests : FunSpec({
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
    test("put letter 'A' and number '5' should returns letter 'F'") {
        // Arrange
        val letter = 'A'
        val number = 5
        val cesar = CesarCypher()

        // Act
        val res = cesar.cypher(letter = letter, shift = number)

        // Assert
        res shouldBe 'F'
    }
    test("put letter 'X' and number '4' should returns letter 'B'") {
        // Arrange
        val letter = 'X'
        val number = 4
        val cesar = CesarCypher()

        // Act
        val res = cesar.cypher(letter = letter, shift = number)

        // Assert
        res shouldBe 'B'
    }
    test("put letter 'a' should returns an error") {
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
    test("put number '-1' should return an error") {
        // Arrange
        val letter = 'A'
        val number = -1
        val cesar = CesarCypher()

        // Act
        fun act() = cesar.cypher(letter = letter, shift = number)

        // Assert
        val exception = shouldThrow<IllegalArgumentException> {
            act()
        }
        exception.message shouldBe "Number must be positive"
    }
})