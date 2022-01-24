package com.alg.boot.webapi.playground

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mockito

internal class AddTest {

    private var add: Add? = null
    private var validNumber: ValidNumber? = null
    private var print: Print? = null

    @BeforeEach
    fun setUp() {
        validNumber = Mockito.mock(ValidNumber::class.java)
        validNumber = Mockito.mock(ValidNumber::class.java)
        print = Mockito.mock(Print::class.java)
        add = Add(validNumber!!, print!!)
    }

    @AfterEach
    fun tearDown() {
        add = null
        validNumber = null
    }

    @Test
    fun addTest() {
        Mockito.`when`(validNumber!!.check(3)).thenReturn(true)
        Mockito.`when`(validNumber!!.check(2)).thenReturn(true)
        add!!.add(3, 2)
        Mockito.verify(validNumber)?.check(3)
        Mockito.verify(validNumber)?.check(2)
    }

    @Test
    fun addPrintTest() {
        // Given
        BDDMockito.given(validNumber!!.check(4)).willReturn(true)
        // When
        add!!.addPrint(4, 4)
        // Then
        Mockito.verify(validNumber, Mockito.times(2))?.check(4)
        Mockito.verify(validNumber, Mockito.atLeast(1))?.check(4)
        Mockito.verify(validNumber, Mockito.atMost(3))?.check(4)
        Mockito.verify(validNumber, Mockito.never())?.check(2)
        Mockito.verify(print)!!.showMessage(8)
        Mockito.verify(print, Mockito.never())!!.showError()
    }

    @Test
    fun addPrintErrorTest() {
        // Given
        BDDMockito.given(validNumber!!.check("4")).willReturn(false)
        // When
        add!!.addPrint("4", "4")
        // Then
        Mockito.verify(print)!!.showError()
    }
}
