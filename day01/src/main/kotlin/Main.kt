import java.io.File

fun main() {
    val input = File(ClassLoader.getSystemResource("input.txt").file).readLines()

    val device = Device()
    println("The net frequency after first calibration is ${device.netFrequency(input)}.")
    println("The first repeated frequency from calibration is ${device.firstRepeatedFrequency(input)}.")
}
