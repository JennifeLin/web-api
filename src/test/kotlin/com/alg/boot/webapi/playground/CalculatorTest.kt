package com.alg.boot.webapi.playground

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class CalculatorTest {

    private lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun addTest() {
        val result = calculator.add(50, 2)
        Assertions.assertEquals(52, result)
    }

    @Test
    fun subtractTest() {
        val result = calculator.subtract(50, 2)
        Assertions.assertEquals(48, result)
    }

    @Test
    fun multiplyTest() {
        val result = calculator.multiply(50, 2)
        Assertions.assertEquals(100, result)
    }

    @Test
    fun divideTest() {
        val result = calculator.divide(50, 2)
        Assertions.assertEquals(25, result)
    }

    @Test
    fun divideByZeroTest() {
        Assertions.assertThrows(ArithmeticException::class.java) {
            calculator.divide(50, 0)
        }
    }

    @Test
    fun remainderTest() {
        val result = calculator.remainder(50, 2)
        Assertions.assertEquals(0, result)
    }

    @Test
    fun powerTest() {
        val result = calculator.power(2, 3)
        Assertions.assertEquals(8, result)
    }

    @Test
    fun squareTest() {
        val result = calculator.square(2)
        Assertions.assertEquals(4, result)
    }

    @Test
    fun squareRootTest() {
        val result = calculator.squareRoot(4)
        Assertions.assertEquals(2, result)
    }

    @Test
    fun squareRootOfNegativeNumberTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            calculator.squareRoot(-4)
        }
    }

    @Test
    fun squareRootOfZeroTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            calculator.squareRoot(0)
        }
    }

    @Test
    fun squareRootOfOneTest() {
        val result = calculator.squareRoot(1)
        Assertions.assertEquals(1, result)
    }

    @Test
    fun squareRootOfTwoTest() {
        val result = calculator.squareRoot(2)
        Assertions.assertEquals(1, result)
    }

    @Test
    fun factorialTest() {
        val result = calculator.factorial(5)
        Assertions.assertEquals(120, result)
    }

    @Test
    fun factorialOfZeroTest() {
        val result = calculator.factorial(0)
        Assertions.assertEquals(1, result)
    }

    @Test
    fun factorialOfNegativeNumberTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            calculator.factorial(-5)
        }
    }

    @Test
    fun factorialOfOneTest() {
        val result = calculator.factorial(1)
        Assertions.assertEquals(1, result)
    }

    @Test
    fun fibonacciTest() {
        val result = calculator.fibonacci(5)
        Assertions.assertEquals(5, result)
    }

    @Test
    fun fibonacciOfZeroTest() {
        val result = calculator.fibonacci(0)
        Assertions.assertEquals(0, result)
    }

    @Test
    fun fibonacciOfOneTest() {
        val result = calculator.fibonacci(1)
        Assertions.assertEquals(1, result)
    }

    @Test
    fun fibonacciOfNegativeNumberTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            calculator.fibonacci(-5)
        }
    }

    @Test
    fun fibonacciOfTwoTest() {
        val result = calculator.fibonacci(2)
        Assertions.assertEquals(1, result)
    }

    @Test
    fun isPrimeTest() {
        val result = calculator.isPrime(5)
        Assertions.assertEquals(true, result)
    }

    @Test
    fun isPrimeOfZeroTest() {
        val result = calculator.isPrime(0)
        Assertions.assertEquals(false, result)
    }

    @Test
    fun isPrimeOfOneTest() {
        val result = calculator.isPrime(1)
        Assertions.assertEquals(false, result)
    }

    @Test
    fun isPrimeOfNegativeNumberTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            calculator.isPrime(-5)
        }
    }

    @Test
    fun isPrimeOfTwoTest() {
        val result = calculator.isPrime(2)
        Assertions.assertEquals(true, result)
    }

    @Test
    fun isPalindromeTest() {
        val result = calculator.isPalindrome(121)
        Assertions.assertEquals(true, result)
    }

    @Test
    fun isPalindromeOfZeroTest() {
        val result = calculator.isPalindrome(0)
        Assertions.assertEquals(true, result)
    }

    @Test
    fun isPalindromeOfOneTest() {
        val result = calculator.isPalindrome(1)
        Assertions.assertEquals(true, result)
    }

    @Test
    fun isPalindromeOfNegativeNumberTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            calculator.isPalindrome(-5)
        }
    }

    @Test
    fun isPalindromeOfTwelveTest() {
        val result = calculator.isPalindrome(12)
        Assertions.assertEquals(false, result)
    }
}
