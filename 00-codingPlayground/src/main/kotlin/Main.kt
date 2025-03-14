@file:Suppress("UNCHECKED_CAST")

fun main() : Unit = Solution().run {

    """
        [5,8,6]
        3
        [2,5]
        11
        [4,7,5]
        4
        [1,2,3,4,10]
        5
    """.trimIndent()
        .split("\n")
        .groupInto(2)
        .appendResult(
            "5" , "0" , "3" , "3"
        )
        .map {
            it.argumentSignature(
                ::intArray ,
                ::long ,
                ::int
            )
        } . run {
            indexer {
                forEach { (candies, k, expected) ->
                    maximumCandies(
                        candies as IntArray,
                        k as Long
                    )
                        .index
                        .showDifference()
                        .ifIncorrect {
                            println( "Failed At ${candies.toList()} $k" )
                        }
                        .coloredOutput(expected as Int)
                        .also(::println)
                }
            }
        }

}