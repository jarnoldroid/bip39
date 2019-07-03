package com.jarnoldroid.bip39

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class SeedGeneratorTest {

    @Test
    fun `given valid mnemonic, when sentence length is 12 with no passphrase, then generate BIP39 Seed`() {
        //Entropy: b909530bc6e3eabda894354a715bb14f
        //1480, 596, 1559, 1134, 501, 758, 1298, 1077, 595, 1110, 1890, 1267
        val sentence = arrayOf("ribbon", "enhance", "seed", "miss", "dirt", "gain", "pelican", "mammal", "engine", "member", "unable", "oyster")
        val mnemonic = Mnemonic(sentence)
        val expectedSeed = Seed("b4d7111d4c7ec63b670f6fce73f71e35eb9f851cd2830b5d608438ebde9330921eafba9312615eda6ce7f334af28b943fcf3a144267ed1f643d01defbe9af331")
        val seed = SeedGenerator().generateSeed(mnemonic)
        assertThat(seed, equalTo(expectedSeed))
    }

    @Test
    fun `given valid mnemonic, when sentence length is 12 with passphrase, then generate BIP39 Seed`() {
        //Entropy: d43da6d7f94849610e2cfe24ed63bf80
        //1697, 1897, 1455, 1940, 1060, 1412, 453, 1278, 295, 856, 1919, 8
        val passPhrase = "test12"
        val sentence = arrayOf("stage", "unfold", "remove", "verb", "loyal", "rack", "december", "panther", "ceiling", "help", "useful", "absurd")
        val mnemonic = Mnemonic(sentence, passPhrase)
        val expectedSeed = Seed("4541f7d53dab10e1a7ebdf662b618e0c353d80a45950f938f76f7e6f69de19f047c89574dda2706c2e495dbc367a90d0e95088867e32347806e0bf2ba8b0c842")
        val seed = SeedGenerator().generateSeed(mnemonic)
        assertThat(seed, equalTo(expectedSeed))
    }

    @Test
    fun `given valid mnemonic, when sentence length is 15 with no passphrase, then generate BIP39 Seed`() {
        //Entropy: 85dbdc606493ef9bd0eae2ee233ee2f90759f243
        //1070, 1783, 192, 1609, 503, 1647, 541, 738, 1905, 207, 1477, 1936, 940, 1993, 115
        val sentence = arrayOf("magic", "ten", "blossom", "since", "discover", "social", "dry", "fox", "until", "boring", "reward", "velvet", "intact", "weird", "attack")
        val mnemonic = Mnemonic(sentence)
        val expectedSeed = Seed("cce7ccbc6b4ec003ed8bda4e0459957a19ab93a050264719ba7a4ea9f892470f5c260ab78336c57611113e9ac39c3663f6e139495884da5d9c64ee6433e03d22")
        val seed = SeedGenerator().generateSeed(mnemonic)
        assertThat(seed, equalTo(expectedSeed))
    }

    @Test
    fun `given valid mnemonic, when sentence length is 15 with passphrase, then generate BIP39 Seed`() {
        //Entropy: 4a4e035f11592c4ca056c80966d07b56067fd820
        //594, 896, 1726, 277, 1174, 306, 1034, 1736, 75, 436, 246, 1376, 831, 1888, 1050
        val passPhrase = "Cheese"
        val sentence = arrayOf("engage", "hybrid", "style", "cargo", "name", "chaos", "life", "suit", "annual", "custom", "burst", "project", "gun", "ugly", "local")
        val mnemonic = Mnemonic(sentence, passPhrase)
        val expectedSeed = Seed("04b3121f5ba68615515d1386830e9f7af3a6699f496c363c3c5409002cbcf35a6ed948b5cc77146db8dc04a5d6b328cfae9b9560361d90f71619af2743e5faec")
        val seed = SeedGenerator().generateSeed(mnemonic)
        assertThat(seed, equalTo(expectedSeed))
    }

    @Test
    fun `given valid mnemonic, when sentence length is 18 with no passphrase, then generate BIP39 Seed`() {
        //Entropy: eeaac410561229d31d5c986c3b92411bee66d953f141e154
        //1909, 689, 32, 1377, 276, 1868, 939, 1176, 865, 1764, 1154, 446, 1843, 869, 638, 321, 1802, 1299
        val sentence = arrayOf("upgrade", "file", "advice", "promote", "card", "trumpet", "install", "narrow", "history", "symptom", "motion", "daughter", "toy", "hole", "exist", "choice", "throw", "pen")
        val mnemonic = Mnemonic(sentence)
        val expectedSeed = Seed("d6f12d460856a9cece9c3f0e0270680ffcceb484099976a2cf8925ad2263c7613660fdcad4050742d97b925fdd44dff59db254e83321458ac474f9b1d1c63195")
        val seed = SeedGenerator().generateSeed(mnemonic)
        assertThat(seed, equalTo(expectedSeed))
    }

    @Test
    fun `given valid mnemonic, when sentence length is 18 with passphrase, then generate BIP39 Seed`() {
        //Entropy: a1b09403ddbfcc8ede1b22b5c5adceab5d9d944b04a90f84
        //1293, 1061, 7, 1499, 2022, 571, 963, 802, 1454, 363, 925, 693, 1742, 1617, 352, 1193, 124, 312
        val passPhrase = "LATIN CAPITAL LETTER A WITH ACUTE"
        val sentence = arrayOf("payment", "lucky", "abstract", "rocket", "wolf", "electric", "journey", "gold", "remind", "coin", "inhale", "find", "supply", "sketch", "clown", "news", "auto", "check")
        val mnemonic = Mnemonic(sentence, passPhrase)
        val expectedSeed = Seed("c874c72980fabd17757b8e07cd0e18009091c5c20594a2461f7000e17cf0ec34447525f56211e9dedea31077acbd028a61b28778ed2e58d1ab5efee90106b73d")
        val seed = SeedGenerator().generateSeed(mnemonic)
        assertThat(seed, equalTo(expectedSeed))
    }

    @Test
    fun `given valid mnemonic, when sentence length is 21 with no passphrase, then generate BIP39 Seed`() {
        //Entropy: 0fde0a5c1b172e5b7673b34a0d9843755c5380a410873f624b1c3b5c
        //126, 1922, 1208, 433, 919, 365, 1742, 947, 592, 870, 134, 1877, 1577, 1538, 1154, 135, 507, 146, 1592, 949, 1581
        val sentence = arrayOf("average", "utility", "novel", "curtain", "indicate", "color", "supply", "island", "energy", "holiday", "awkward", "turkey", "share", "scare", "motion", "axis", "disorder", "banner", "shove", "issue", "shield")
        val mnemonic = Mnemonic(sentence)
        val expectedSeed = Seed("007d44866e546ce3e4d28ca0b022d0f7a091e27b097e77af97d7b78c44bc11159f5ddb5422dd503ae0d094d0931c896c380658253e66141310c4d087e834570d")
        val seed = SeedGenerator().generateSeed(mnemonic)
        assertThat(seed, equalTo(expectedSeed))
    }

    @Test
    fun `given valid mnemonic, when sentence length is 21 with passphrase, then generate BIP39 Seed`() {
        //Entropy: daf6077155c0d7d742f8894bacb8b6b48f59de59077e37954a261b09
        //1751, 1409, 1762, 1372, 107, 1885, 95, 137, 605, 814, 365, 840, 1964, 1913, 800, 1918, 444, 1362, 1100, 432, 1215
        val passPhrase = "Å"
        val sentence = arrayOf("sustain", "rabbit", "sword", "process", "aspect", "two", "armor", "bachelor", "entry", "grape", "color", "harbor", "void", "upset", "goat", "used", "daring", "prevent", "maze", "current", "obey")
        val mnemonic = Mnemonic(sentence, passPhrase)
        val expectedSeed = Seed("d18efc05337e1a487dc741350419401550e17bb477da42ae270c5894daf76cb5874ed8997800d8ffef1be9ffff83cd7a0d904e20166dcaa53becfe89176eef49")
        val seed = SeedGenerator().generateSeed(mnemonic)
        assertThat(seed, equalTo(expectedSeed))
    }

    @Test
    fun `given valid mnemonic, when sentence length is 24 with no passphrase, then generate BIP39 Seed`() {
        //Entropy: 7a042dc0cea5f273c9180b59208e2d7a5ce90caa83afb689bca661b9088b4e66
        //976, 267, 897, 1258, 761, 463, 291, 11, 713, 35, 1114, 1957, 1652, 1074, 1360, 943, 1460, 623, 332, 1563, 1156, 557, 460, 1650
        val sentence = arrayOf("key", "cannon", "ice", "outer", "game", "delay", "caught", "accident", "float", "afford", "mercy", "visa", "soldier", "main", "present", "invest", "repair", "evil", "civil", "sell", "mountain", "east", "define", "soft")
        val mnemonic = Mnemonic(sentence)
        val expectedSeed = Seed("e41dd1e9dc2624e8231c7cdb058f5672b124df919609782b08cae8a17c19fd69cf5e93fbc73eaf26b4b810576e230a04db32f9602467be3224fccf409641deb5")
        val seed = SeedGenerator().generateSeed(mnemonic)
        assertThat(seed, equalTo(expectedSeed))
    }

    @Test
    fun `given valid mnemonic, when sentence length is 24 with passphrase, then generate BIP39 Seed`() {
        //Entropy: a80694afa037216a643b932fee1cb73007b5af11b3df4dcf575e4458f45a3efa
        //1344, 421, 351, 515, 912, 1449, 1159, 915, 383, 903, 366, 768, 986, 1724, 566, 991, 622, 981, 1724, 1093, 1146, 360, 2015, 543
        val passPhrase = "å1Ø2ø3Æ?!£$%æ9eba21l001058f5FFDD"
        val sentence = arrayOf("pool", "cruise", "cloud", "document", "improve", "release", "movie", "include", "copper", "ill", "column", "gas", "kitten", "stuff", "egg", "know", "evidence", "kingdom", "stuff", "master", "monster", "code", "winner", "dumb")
        val mnemonic = Mnemonic(sentence, passPhrase)
        val expectedSeed = Seed("64541385731fa78df119cbabe3ffc27a06e2a4cf6e28df0a895c99c1909945e8ed8cc1b52cc2def904916dd7e7add05cdb56dc3d639fdf22ea9f2abcc02d3b47")
        val seed = SeedGenerator().generateSeed(mnemonic)
        assertThat(seed, equalTo(expectedSeed))
    }
}