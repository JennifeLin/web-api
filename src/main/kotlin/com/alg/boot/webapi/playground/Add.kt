package com.alg.boot.webapi.playground

class Add(private var validNumber: ValidNumber) {
    fun add(a: Int, b: Int): Int {
        return if (validNumber.check(a) && validNumber.check(b)) {
            a + b
        } else {
            throw IllegalArgumentException("Invalid number")
        }
    }

    fun squareDoubleToInt(a: Double): Int {
        return validNumber.doubleToInt(a) * 2
    }
}
