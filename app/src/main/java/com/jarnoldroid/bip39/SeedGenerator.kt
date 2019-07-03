package com.jarnoldroid.bip39

import org.apache.commons.codec.binary.Hex
import java.text.Normalizer
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec


class SeedGenerator {

    private companion object {
        const val DEFAULT_PASSPHRASE = "mnemonic"
        const val ALGORITHM = "PBKDF2WithHmacSHA512"
        const val NUMBER_OF_ITERATIONS = 2048
        const val KEY_LENGTH = 512
    }

    fun generateSeed(mnemonic: Mnemonic): Seed {
        val passphrase = DEFAULT_PASSPHRASE + mnemonic.passphrase
        val salt = passphrase.normalise().toByteArray()
        val sentence = mnemonic.sentence.asString()
        val password = sentence.normalise().toCharArray()
        val pbeKeySpec = PBEKeySpec(password, salt, NUMBER_OF_ITERATIONS, KEY_LENGTH)
        val key = SecretKeyFactory.getInstance(ALGORITHM).generateSecret(pbeKeySpec)
        val bytesToHex = Hex.encodeHexString(key.encoded)
        return Seed(bytesToHex)
    }

    private fun String.normalise(): String = Normalizer.normalize(this, Normalizer.Form.NFKD)
    private fun Array<MnemonicWord>.asString() = this.joinToString(" ")
}