package juspay

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NearestMeetingCellTest {

    @Test
    fun nearestMeetingCellsTest() : Unit = NearestMeetingCell().run {

        nearestMeetingCells(
            23 ,
            listOf( 4, 4, 1, 4, 13, 8, 8, 8, 0, 8, 14, 9, 15, 11, -1, 10, 15, 22, 22, 22, 22, 22, 21 ) ,
            9, 2
        ).let {
            assertEquals( it , 4 )
        }

    }

}