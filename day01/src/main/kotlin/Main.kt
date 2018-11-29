import java.io.File

fun main() {
    val input = File(ClassLoader.getSystemResource("input.txt").file).readLines()

    val device = Device()
    print("The net frequency after first calibration is ${device.netFrequency(input)}")
}
