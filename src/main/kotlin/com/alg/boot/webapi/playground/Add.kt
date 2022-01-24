package com.alg.boot.webapi.playground

class Add(private var validNumber: ValidNumber, private var print: Print) {

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

    fun addPrint(a: Any, b: Any) {
        if (validNumber.check(a) && validNumber.check(b)) {
            val result = a as Int + b as Int
            print.showMessage(result)
        } else {
            print.showError()
        }
    }
}
