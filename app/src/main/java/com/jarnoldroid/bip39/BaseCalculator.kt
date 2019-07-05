package com.jarnoldroid.bip39

import java.lang.IllegalStateException
import java.math.BigInteger
import kotlin.math.floor
import kotlin.math.log2



class BaseCalculator {

    fun calculateBase(rawEntropy: String): Base {

        val baseType = when {
            rawEntropy.isBinary() -> BaseType.BINARY
            rawEntropy.isBase6() -> BaseType.BASE6
            rawEntropy.isDice() -> BaseType.DICE6
            rawEntropy.isDecimal() -> BaseType.DECIMAL
            rawEntropy.isHex() -> BaseType.HEX
            rawEntropy.isCard() -> BaseType.CARD
            else -> throw IllegalStateException("Invalid Entropy")
        }

        val baseInts = rawEntropy.toInts(baseType)

        var entropyInts = BigInteger.ZERO

        var index = baseInts.size
        while (index-- > 0) {
            val int = baseInts[index]
            val thisInt = int.toBigInteger()
            val power = (baseInts.size - 1) - index
            val additionalEntropy = baseType.base.toBigInteger().pow(power).multiply(thisInt)
            entropyInts = entropyInts.add(additionalEntropy)
        }

        val expectedBits = floor(baseInts.size * log2(baseType.base.toDouble()))

        var entropyBinary = entropyInts.toString(2)

        while (entropyBinary.length < expectedBits) {
            entropyBinary = "0$entropyBinary"
        }

        val numOfBytes = entropyBinary.length / 8
        val entropyBytes = IntArray(numOfBytes)

        for (i in 0 until numOfBytes) {
            val start = 8 * i
            val byteAsBits = entropyBinary.substring(start, start + 8)
            val byteAsInt = Integer.parseInt(byteAsBits, 2)
            entropyBytes[i] = byteAsInt
        }

        return Base(baseType, baseInts, entropyInts, entropyBinary, entropyBytes)
    }
}

private fun String.toInts(baseType: BaseType): List<Int> = this.map { Integer.parseInt(it.toString(), baseType.base) }

data class Base(val type: BaseType,
                val baseInts: List<Int>,
                val entropyInts: BigInteger,
                val entropyBinary: String,
                val entropyBytes: IntArray)

enum class BaseType(val base: Int) {
    BINARY(1),
    BASE6(6),
    DICE6(6),
    DECIMAL(10),
    HEX(16),
    CARD(52)
}

fun String.isBinary(): Boolean = this.allCharsMatch("[0-1]")
fun String.isBase6(): Boolean = this.allCharsMatch("[0-5]")
fun String.isDice(): Boolean = this.allCharsMatch("[1-6]")
fun String.isDecimal(): Boolean = this.allCharsMatch("[0-9]")
fun String.isHex(): Boolean = this.toUpperCase().allCharsMatch("[0-9A-F]")
fun String.isCard(): Boolean = this.toUpperCase().allCharPairsMatch("([A2-9TJQK][CDHS])")


fun String.allCharsMatch(pattern: String) = this.filter { it.match(pattern) } == this

fun String.allCharPairsMatch(pattern: String): Boolean {

   if (this.length.isOdd()) {
       return false
   }

    this.evenIndexChars().zip(this.oddIndexChars()).forEach {
        if (!it.match(pattern)) {
            return false
        }
    }

    return true
}

fun String.oddIndexChars() = this.filterIndexed { index: Int, _ -> index.isOdd() }
fun String.evenIndexChars() = this.filterIndexed { index: Int, _ -> index.isEven() }

fun Int.isOdd() = this % 2 == 1
fun Int.isEven() = this % 2 == 0

fun Pair<Char,Char>.match(pattern: String) = Regex(pattern) matches ("" + this.first + this.second)
fun Char.match(pattern: String) = Regex(pattern) matches this.toString()

// didn't work
//    return this.evenIndexChars().zip(this.oddIndexChars()).filter { it.match(pattern) }.asString() == this
fun List<Pair<Char, Char>>.asString() = this.joinToString { "" + it.first + it.second }

