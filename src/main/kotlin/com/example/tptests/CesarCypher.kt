package com.example.tptests

class CesarCypher {
    private val alphabet = ('A'..'Z').toMutableList()

    fun cypher(letter: Char, shift: Int): Char {
        return alphabet.elementAt(alphabet.indexOf(letter) + shift)
    }
}