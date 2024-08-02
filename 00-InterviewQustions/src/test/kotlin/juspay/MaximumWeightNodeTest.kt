package juspay

import kotlin.test.Test
import kotlin.test.assertEquals

class MaximumWeightNodeTest {

    @Test
    fun maxWeightCellTest() {
        MaximumWeightNode
            .maxWeightCell(
                4, listOf(2, 0, -1, 2)
            ).let {
                assertEquals(
                    it , 2
                )
            }
        MaximumWeightNode
            .maxWeightCell(
                23 ,
                listOf(4 , 4 ,  1, 4, 13, 8, 8 ,8 ,0, 8, 14, 9, 15, 11, -1, 10, 15, 22, 22, 22, 22, 22, 21 )
            ).let {
                assertEquals(
                    it , 22
                )
            }
    }

}