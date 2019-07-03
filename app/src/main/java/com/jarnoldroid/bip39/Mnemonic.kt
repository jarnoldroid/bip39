package com.jarnoldroid.bip39

typealias MnemonicWord = String

data class Mnemonic(val sentence: Array<MnemonicWord>, val passphrase: String = "") {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Mnemonic

        if (!sentence.contentEquals(other.sentence)) return false

        return true
    }

    override fun hashCode(): Int {
        return sentence.contentHashCode()
    }
}