package com.example.tptests

class CesarCypher {
    private val alphabet = ('A'..'Z').toMutableList()

    fun cypher(letter: Char, shift: Int): Char {
        if (letter.isLowerCase()) {
            throw IllegalArgumentException(
                "Letter must be uppercase",
            )
        }
        if (shift < 0) {
            throw IllegalArgumentException(
                "Number must be positive",
            )
        }
        val indexToReturn = alphabet.indexOf(letter) + shift
        return alphabet.elementAt(indexToReturn.mod(alphabet.size))
    }
}