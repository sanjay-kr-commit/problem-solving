fun main() : Unit = Solution().run {

    """
        [100,4,200,1,3,2]
        [0,3,7,2,5,8,4,6,0,1]
        [1,0,1,2]
    """.trimIndent()
        .split("\n")
        .groupInto(1)
        .appendResult(
            "4" , "9" , "3" , "25001"
        ).argumentSignature(
            ::intArray ,
            ::int
        ) recordState {
            forEach ( 2) { (arr, expected) ->
                longestConsecutive(
                    arr as IntArray
                )
                    .index
                    .showDifference()
                    .coloredOutput( expected as Int )
                    .also(::println)
            }
        }


}
