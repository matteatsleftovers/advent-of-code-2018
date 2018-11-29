import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row

class DeviceTest : StringSpec({

    "Net frequency change" {
        forall(
                // @formatter:off
                row(Device(), listOf("+1", "-2", "+3", "+1"),  3),
                row(Device(), listOf("+1", "+1", "+1"),        3),
                row(Device(), listOf("+1", "+1", "-2"),        0),
                row(Device(), listOf("-1", "-2", "-3"),       -6)
                // @formatter:on
        ) { device, input, expected ->
            device.netFrequency(frequencies = input) shouldBe expected
        }
    }

})