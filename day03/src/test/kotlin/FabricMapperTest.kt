import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row

class FabricMapperTest: StringSpec({

    "Correctly reads each claim" {
        forall(
                row(FabricMapper(Fabric(8, 8)), "#1 @ 1,3: 4x4", Claim(1, Pair(1, 3), Pair(4, 4))),
                row(FabricMapper(Fabric(8, 8)), "#2 @ 3,1: 4x4", Claim(2, Pair(3, 1), Pair(4, 4))),
                row(FabricMapper(Fabric(8, 8)), "#3 @ 5,5: 2x2", Claim(3, Pair(5, 5), Pair(2, 2)))
        ) { fabricMapper, input, expected ->
            fabricMapper.convertStringToClaim(input) shouldBe expected
        }
    }

    "Claim area at least twice claimed" {
        forall(
                row(FabricMapper(Fabric(8, 8)),
                        listOf("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2"),
                        4)
        ) { fabricMapper, input, expected ->
            fabricMapper.calculateAreaAtLeastTwiceClaimed(claims = input) shouldBe expected
        }
    }

    "Claim with no overlaps" {
        forall(
                row(FabricMapper(Fabric(8, 8)),
                        listOf("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2"),
                        3)
        ) { fabricMapper, input, expected ->
            fabricMapper.calculateAreaAtLeastTwiceClaimed(claims = input)
            fabricMapper.getIntactClaim(claims = input) shouldBe expected
        }
    }

})