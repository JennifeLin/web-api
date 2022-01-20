package com.alg.boot.webapi.playground

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

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
    fun testValidNumber() {
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
}
