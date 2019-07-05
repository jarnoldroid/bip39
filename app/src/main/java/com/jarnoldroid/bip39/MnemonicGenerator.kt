package com.jarnoldroid.bip39

class MnemonicGenerator(val baseCalculator: BaseCalculator) {


    fun generateMnemonic(entropy: String): Array<MnemonicWord> {

        val base = baseCalculator.calculateBase(entropy)

        //toMnemonic

        return arrayOf()
    }



}