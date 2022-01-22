package com.alg.boot.webapi.playground

class ValidNumber {

    fun check(o: Any?): Boolean {
        if (o == null) throw ArithmeticException("Error el parámetro no puede ser nulo")
        return if (o is Int) {
            o in 0..9
        } else {
            false
        }
    }
}
