import java.io.File

fun main() {
    val input = File(ClassLoader.getSystemResource("input.txt").file).readLines()

    val boxIdChecker = BoxIdChecker()
    println("The checksum of the strings is ${boxIdChecker.checkSum(input)}.")
    println("The longest common string is ${boxIdChecker.commonLetters(input)}.")
}
