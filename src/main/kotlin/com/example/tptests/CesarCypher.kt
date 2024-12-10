package com.example.tptests

class CesarCypher {
    private val alphabet = ('A'..'Z').toMutableList()

    fun cypher(letter: Char, shift: Int): Char {
        if (letter.isLowerCase()) {
            throw IllegalArgumentException(
                "Letter must be uppercase",
                IllegalStateException("Original cause: illegal state")
            )
        }
        return alphabet.elementAt(alphabet.indexOf(letter) + shift)
    }
}