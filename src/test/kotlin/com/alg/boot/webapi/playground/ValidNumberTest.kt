package com.alg.boot.webapi.playground

import org.junit.jupiter.api.*

internal class ValidNumberTest {
    private var validNumber: ValidNumber? = null

    @BeforeEach
    fun setUp() {
        validNumber = ValidNumber()
    }

    @AfterEach
    fun tearDown() {
        validNumber = null
    }

    @Test
    fun validNumberTest() {
        Assertions.assertAll(
            {Assertions.assertEquals(true, validNumber!!.check(0))},
            {Assertions.assertEquals(true, validNumber!!.check(5))},
            {Assertions.assertEquals(true, validNumber!!.check(9))},
            {Assertions.assertEquals(false, validNumber!!.check(10))},
            {Assertions.assertEquals(false, validNumber!!.check(-1))},
            {Assertions.assertEquals(false, validNumber!!.check("Int.MAX_VALUE"))},
            {Assertions.assertEquals(false, validNumber!!.check(5.5))},
        )
    }

    @Nested
    inner class DoubleToIntTests {
        @Test
        fun doubleToIntTest() {
            Assertions.assertEquals(3, validNumber!!.doubleToInt(3.9999))
        }

        @Test
        fun doubleToIntErrorTest() {
            Assertions.assertEquals(0, validNumber!!.doubleToInt("3.9999"))
        }
    }
}
