package com.jarnoldroid.bip39

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.junit.Test
import java.lang.IllegalStateException

class BaseCalculatorTest {

    @Test
    fun `given binary string, when detecting base, then return BINARY`() {
        val base = BaseCalculator().calculateBase("1010101")
        assertThat(base.type, equalTo(BaseType.BINARY))
    }

    @Test
    fun `given base6 string, when detecting base, then return BASE6`() {
        val base = BaseCalculator().calculateBase("1234")
        assertThat(base.type, equalTo(BaseType.BASE6))
    }

    @Test
    fun `given dice string, when detecting base, then return DICE6`() {
        val base = BaseCalculator().calculateBase("123456")
        assertThat(base.type, equalTo(BaseType.DICE6))
    }

    @Test
    fun `given decimal string, when detecting base, then return DECIMAL`() {
        val base = BaseCalculator().calculateBase("1234567")
        assertThat(base.type, equalTo(BaseType.DECIMAL))
    }

    @Test
    fun `given hex string, when detecting base, then return HEX`() {
        val base = BaseCalculator().calculateBase("b909530bc6e3eabda894354a715bb14f")
        assertThat(base.type, equalTo(BaseType.HEX))
        val entropyInts = listOf(11, 9, 0, 9, 5, 3, 0, 11, 12, 6, 14, 3, 14, 10, 11, 13, 10, 8, 9, 4, 3, 5, 4, 10, 7, 1, 5, 11, 11, 1, 4, 15)
        assertThat(base.baseInts, equalTo(entropyInts))
    }

    @Test
    fun `given card string, when detecting base, then return CARD`() {
        val base = BaseCalculator().calculateBase("AH2D3S4C5HJDQSKC")
        assertThat(base.type, equalTo(BaseType.CARD))
    }

    @Test (expected = IllegalStateException::class)
    fun `given invalid hex string, when detecting base, then throw IllegalStateException`() {
        BaseCalculator().calculateBase("1234567abcdefgh")
    }

    @Test (expected = IllegalStateException::class)
    fun `given invalid card string containing 1, when detecting base, then throw IllegalStateException`() {
        BaseCalculator().calculateBase("1H2D3S4C5HJDQSKC")
    }

    @Test (expected = IllegalStateException::class)
    fun `given invalid card string missing a char, when detecting base, then throw IllegalStateException`() {
        BaseCalculator().calculateBase("AH2D3S4C5HJDQSK")
    }
}