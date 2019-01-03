import java.io.File

fun main() {
    val input = File(ClassLoader.getSystemResource("input.txt").file).readLines()

    val fabricMapper = FabricMapper(Fabric(1000, 1000))
    println("The area at least twice claimed is ${fabricMapper.calculateAreaAtLeastTwiceClaimed(input)}.")
}
