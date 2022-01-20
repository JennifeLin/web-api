package com.alg.boot.webapi.playground

import kotlin.math.pow
import kotlin.math.sqrt

class Calculator {
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun subtract(a: Int, b: Int): Int {
        return a - b
    }

    fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    fun divide(a: Int, b: Int): Int {
        if (b == 0) {
            throw IllegalArgumentException("Division by zero")
        }
        return a / b
    }

    fun remainder(a: Int, b: Int): Int {
        return a % b
    }

    fun power(a: Int, b: Int): Int {
        return a.toDouble().pow(b).toInt()
    }

    fun square(a: Int): Int {
        return a.toDouble().pow(2).toInt()
    }

    fun squareRoot(a: Int): Int {
        if (a <= 0) {
            throw IllegalArgumentException("Cannot calculate square root of negative number")
        }
        return sqrt(a.toDouble()).toInt()
    }

    fun factorial(a: Int): Int {
        if (a < 0) {
            throw IllegalArgumentException("Factorial of negative number is not defined")
        }
        return if (a == 0) 1 else a * factorial(a - 1)
    }

    fun fibonacci(a: Int): Int {
        if (a < 0) {
            throw IllegalArgumentException("Fibonacci of negative number is not defined")
        }
        return if (a == 0) 0 else if (a == 1) 1 else fibonacci(a - 1) + fibonacci(a - 2)
    }

    fun isPrime(a: Int): Boolean {
        if (a < 0) {
            throw IllegalArgumentException("Prime of negative number is not defined")
        }
        if (a < 2) return false
        for (i in 2 until a) {
            if (a % i == 0) return false
        }
        return true
    }

    fun isPalindrome(a: Int): Boolean {
        if (a < 0) {
            throw IllegalArgumentException("Palindrome of negative number is not defined")
        }
        val s = a.toString()
        return s == s.reversed()
    }
}
