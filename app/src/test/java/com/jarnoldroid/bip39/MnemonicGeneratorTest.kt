package com.jarnoldroid.bip39

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class MnemonicGeneratorTest {

    @Test
    fun `given valid entropy, when entropy length is 32, then generate BIP39 Mnemonic`() {
        val entropy = "b909530bc6e3eabda894354a715bb14f"
        val mnemonic: Array<MnemonicWord> = MnemonicGenerator(BaseCalculator()).generateMnemonic(entropy)
        val sentence: Array<MnemonicWord> = arrayOf("ribbon", "enhance", "seed", "miss", "dirt", "gain", "pelican", "mammal", "engine", "member", "unable", "oyster")
        assertThat(mnemonic, equalTo(sentence))
    }
}