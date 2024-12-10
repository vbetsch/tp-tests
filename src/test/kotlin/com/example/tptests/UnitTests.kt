package com.example.tptests

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.arbitrary
import io.kotest.property.arbitrary.int
import io.kotest.property.checkAll

class UnitTests : FunSpec({
    context("Examples") {
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
        test("put number '-1' should returns an error") {
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
    }

    context("Properties") {
        test("put any letter and number '0' should returns input letter") {
            // Arrange
            val cesar = CesarCypher()
            val alphabet = ('A'..'Z').toMutableList()
            val upperCaseLetters = arbitrary { alphabet.random() }

            checkAll(upperCaseLetters) { anyLetter ->
                // Act
                val res = cesar.cypher(letter = anyLetter, shift = 0)

                // Assert
                res shouldBe anyLetter
            }
        }
        test("put any lowercase letter should returns an error") {
            // Arrange
            val cesar = CesarCypher()
            val alphabet = ('a'..'z').toMutableList()
            val lowerCaseLetters = arbitrary { alphabet.random() }

            checkAll(lowerCaseLetters) { anyLetter ->
                // Act
                fun act() = cesar.cypher(letter = anyLetter, shift = 0)

                // Assert
                val exception = shouldThrow<IllegalArgumentException> {
                    act()
                }
                exception.message shouldBe "Letter must be uppercase"
            }
        }
        test("put any negative number should returns an error") {
            // Arrange
            val cesar = CesarCypher()
            val negativeNumbers = Arb.int(Int.MIN_VALUE, -1)

            checkAll(negativeNumbers) { anyNumber ->
                // Act
                fun act() = cesar.cypher(letter = 'A', shift = anyNumber)

                // Assert
                val exception = shouldThrow<IllegalArgumentException> {
                    act()
                }
                exception.message shouldBe "Number must be positive"
            }
        }
    }
})