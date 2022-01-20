package com.alg.boot.webapi.playground

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
        Mockito.`when`(validNumber!!.check(Mockito.anyInt())).thenReturn(true)
    }

    @Test
    fun addTest() {
        add!!.add(3, 2)
        Mockito.verify(validNumber)?.check(3)
    }
}
