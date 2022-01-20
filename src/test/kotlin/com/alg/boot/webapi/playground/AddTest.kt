package com.alg.boot.webapi.playground

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito

internal class AddTest {

    private var add: Add? = null
    private var validNumber: ValidNumber? = null

    @BeforeEach
    fun setUp() {
        validNumber = Mockito.mock(ValidNumber::class.java)
        Mockito.`when`(validNumber!!.check(Mockito.anyInt())).thenReturn(true)
        add = Add(validNumber!!)
    }

    @AfterEach
    fun tearDown() {
        add = null
        validNumber = null
    }

    @Test
    fun addTest() {
        add!!.add(3, 2)
        Mockito.verify(validNumber)?.check(3)
        Mockito.verify(validNumber)?.check(2)
    }
}
