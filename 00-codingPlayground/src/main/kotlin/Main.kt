fun main() : Unit = Solution().run {

    """
        ["bread"]
        [["yeast","flour"]]
        ["yeast","flour","corn"]
        ["bread","sandwich"]
        [["yeast","flour"],["bread","meat"]]
        ["yeast","flour","meat"]
        ["bread","sandwich","burger"]
        [["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]]
        ["yeast","flour","meat"]
    """.trimIndent()
        .split("\n")
        .groupInto(3)
//        .appendResult(
//        )
        .argumentSignature(
            ::stringArray ,
            {
                serializeStringToListOf(::listOfString)
            },
            ::stringArray
        ) recordState {
            forEach (
                2
            ) { (r,i,s) ->
                findAllRecipes(
                    r as Array<String> ,
                    i as List<List<String>> ,
                    s as Array<String>

                )
//                    .index
//                    .showDifference()
//                    .recordStatus
//                    .coloredOutput( expected as Int )
                    .also(::println)
            }
            logReport
        }
}