import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row

class BoxIdCheckerTest : StringSpec({

    "Total checksum" {
        forall(
                row(BoxIdChecker(),
                        listOf("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab"),
                        12)
        ) { boxIdChecker, input, expected ->
            boxIdChecker.checkSum(strings = input) shouldBe expected
        }
    }

    "twoOf" {
        forall(
                row(BoxIdChecker(), "abcdef", 0),
                row(BoxIdChecker(), "bababc", 1),
                row(BoxIdChecker(), "abbcde", 1),
                row(BoxIdChecker(), "abcccd", 0),
                row(BoxIdChecker(), "aabcdd", 1),
                row(BoxIdChecker(), "abcdee", 1),
                row(BoxIdChecker(), "ababab", 0)
        ) { boxIdChecker, input, expected ->
            boxIdChecker.twoOf(string = input) shouldBe expected
        }
    }

    "threeOf" {
        forall(
                row(BoxIdChecker(), "abcdef", 0),
                row(BoxIdChecker(), "bababc", 1),
                row(BoxIdChecker(), "abbcde", 0),
                row(BoxIdChecker(), "abcccd", 1),
                row(BoxIdChecker(), "aabcdd", 0),
                row(BoxIdChecker(), "abcdee", 0),
                row(BoxIdChecker(), "ababab", 1)
        ) { boxIdChecker, input, expected ->
            boxIdChecker.threeOf(string = input) shouldBe expected
        }
    }

    "Common letters between two correct box IDs" {
        forall(
                row(BoxIdChecker(),
                        listOf("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz"),
                        "fgij")
        ) { boxIdChecker, input, expected ->
            boxIdChecker.commonLetters(strings = input) shouldBe expected
        }
    }

    "Longest common subsequence" {
        forall(
                row(BoxIdChecker(), listOf("abcde", "axcye"), "ace"),
                row(BoxIdChecker(), listOf("fghij", "fguij"), "fgij"),
                row(BoxIdChecker(), listOf("AGCAT", "GACA"), "GCA"),
                row(BoxIdChecker(), listOf("bvhfawknyoqsudzrpgslecmtkj", "bpufawcnyoqxldzrpgsleimtkj"), "bfawnyoqdzrpgslemtkj")
        ) { boxIdChecker, input, expected ->
            boxIdChecker.lcs(input[0], input[1]) shouldBe expected
        }
    }

})