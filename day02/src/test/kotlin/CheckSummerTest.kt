import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row

class CheckSummerTest : StringSpec({

    "Total checksum" {
        forall(
                row(CheckSummer(),
                        listOf("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab"),
                        12)
        ) { checkSummer, input, expected ->
            checkSummer.checkSum(strings = input) shouldBe expected
        }
    }

    "twoOf" {
        forall(
                row(CheckSummer(), "abcdef", 0),
                row(CheckSummer(), "bababc", 1),
                row(CheckSummer(), "abbcde", 1),
                row(CheckSummer(), "abcccd", 0),
                row(CheckSummer(), "aabcdd", 1),
                row(CheckSummer(), "abcdee", 1),
                row(CheckSummer(), "ababab", 0)
        ) { checkSummer, input, expected ->
            checkSummer.twoOf(string = input) shouldBe expected
        }
    }

    "threeOf" {
        forall(
                row(CheckSummer(), "abcdef", 0),
                row(CheckSummer(), "bababc", 1),
                row(CheckSummer(), "abbcde", 0),
                row(CheckSummer(), "abcccd", 1),
                row(CheckSummer(), "aabcdd", 0),
                row(CheckSummer(), "abcdee", 0),
                row(CheckSummer(), "ababab", 1)
        ) { checkSummer, input, expected ->
            checkSummer.threeOf(string = input) shouldBe expected
        }
    }

})