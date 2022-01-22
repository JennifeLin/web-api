package com.alg.boot.webapi.playground

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

internal class HeroTest {

    @Test
    @RepeatedTest(20)
    fun hashCodeTest() {
        val size = 2_000_000
        val map: HashMap<Int, String> = HashMap()
        for (i in 1..size) {
            val hero = Hero(i.toLong(), "name", "power", "ego")
            map[hero.hashCode()] = hero.toString()
        }
        Assertions.assertEquals(size, map.keys.distinct().size)
    }
}
