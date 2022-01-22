package com.alg.boot.webapi.playground

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class AddTestMockValidNumberTest {
    @InjectMocks
    private val add: Add? = null
    @Mock
    private val validNumber: ValidNumber? = null

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun addTest() {
        Mockito.`when`(validNumber!!.check(Mockito.anyInt())).thenReturn(true)
        add!!.add(3, 2)
        Mockito.verify(validNumber)?.check(3)
        Assertions.assertAll(
            { Assertions.assertEquals(true, validNumber.check(3)) },
            { Assertions.assertEquals(true, validNumber.check(0)) },
            { Assertions.assertEquals(true, validNumber.check(9)) },
        )
    }

    @Test
    fun launchExceptionTest() {
        Mockito.`when`(validNumber!!.check(null)).thenThrow(ArithmeticException::class.java)
        var exception: ArithmeticException? = null
        try {
            validNumber.check(null)
        } catch (e: ArithmeticException) {
            exception = e
        }
        Assertions.assertNotNull(exception)
    }

    @Test
    fun launchRealMethodTest() {
        Mockito.`when`(validNumber!!.check(Mockito.anyInt())).thenCallRealMethod()
        Assertions.assertAll(
            { Assertions.assertEquals(true, validNumber.check(3)) },
            { Assertions.assertEquals(true, validNumber.check(0)) },
            { Assertions.assertEquals(true, validNumber.check(9)) },
            { Assertions.assertEquals(false, validNumber.check(-1)) },
            { Assertions.assertEquals(false, validNumber.check(10)) },
        )
    }
}
