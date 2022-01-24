package com.alg.boot.webapi.playground

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.mockito.*
import org.mockito.stubbing.Answer


class AddTestMockValidNumberTest {
    @InjectMocks
    private var add: Add? = null
    @Mock
    private var validNumber: ValidNumber? = null
    @Mock
    private var print: Print? = null
    @Captor
    private val captor: ArgumentCaptor<Int>? = null

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        add = Add(validNumber!!, print!!)
    }

    @Test
    fun addTest() {
        Mockito.`when`(validNumber!!.check(3)).thenReturn(true)
        Mockito.`when`(validNumber!!.check(2)).thenReturn(true)
        add!!.add(3, 2)
        Mockito.verify(validNumber)?.check(3)
        Assertions.assertEquals(true, validNumber!!.check(3))
    }

    @Test
    fun addBDDTest() {
        // Given
        BDDMockito.given(validNumber!!.check(BDDMockito.anyInt())).willReturn(true)
        // When
        add!!.add(3, 2)
        // Then
        Assertions.assertEquals(true, validNumber!!.check(3))
    }

    @Test
    fun launchExceptionTest() {
        Mockito.`when`(validNumber!!.check(null)).thenThrow(ArithmeticException::class.java)
        var exception: ArithmeticException? = null
        try {
            validNumber!!.check(null)
        } catch (e: ArithmeticException) {
            exception = e
        }
        Assertions.assertNotNull(exception)
    }

    @Test
    fun launchRealMethodTest() {
        Mockito.`when`(validNumber!!.check(Mockito.anyInt())).thenCallRealMethod()
        Assertions.assertAll(
            { Assertions.assertEquals(true, validNumber!!.check(3)) },
            { Assertions.assertEquals(true, validNumber!!.check(0)) },
            { Assertions.assertEquals(true, validNumber!!.check(9)) },
            { Assertions.assertEquals(false, validNumber!!.check(-1)) },
            { Assertions.assertEquals(false, validNumber!!.check(10)) },
        )
    }

    @Test
    fun squareDoubleToIntAnswersTest() {
        val value = 7.7777
        val answer: Answer<Int> = Answer { 7 }
        Mockito.`when`(validNumber!!.doubleToInt(value)).thenAnswer(answer)
        Assertions.assertEquals(14, add!!.squareDoubleToInt(value))
    }

    @Test
    fun captorTest() {
        // Given
        BDDMockito.given(validNumber!!.check(4)).willReturn(true)
        BDDMockito.given(validNumber!!.check(5)).willReturn(true)
        // When
        add!!.addPrint(4, 5)
        // Then
        Mockito.verify(print)!!.showMessage(captor!!.capture())
        Assertions.assertEquals(9, captor.value)
    }

    @Nested
    inner class SpyAndMockTest {
        @Spy
        private var spyList: MutableList<String> = ArrayList()

        @Mock
        private var mockList: MutableList<String> = ArrayList()

        @BeforeEach
        fun setup() {
            MockitoAnnotations.openMocks(this)
        }

        @Test
        fun spyTest() {
            spyList.add("1")
            spyList.add("2")
            spyList.add("3")
            Mockito.verify(spyList).add("1")
            Mockito.verify(spyList).add("2")
            Mockito.verify(spyList).add("3")
            Assertions.assertEquals(3, spyList.size)
        }

        @Test
        fun mockTest() {
            mockList.add("1")
            mockList.add("2")
            mockList.add("3")
            Mockito.verify(mockList).add("1")
            Mockito.verify(mockList).add("2")
            Mockito.verify(mockList).add("3")
            Assertions.assertEquals(0, mockList.size)
        }
    }

}
