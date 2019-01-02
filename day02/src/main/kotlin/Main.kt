import java.io.File

fun main() {
    val input = File(ClassLoader.getSystemResource("input.txt").file).readLines()

    val checkSummer = CheckSummer()
    println("The checksum of the strings is ${checkSummer.checkSum(input)}.")
}
