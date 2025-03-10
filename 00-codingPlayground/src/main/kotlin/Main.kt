fun main() : Unit = Solution().run {

    """
        "aeioqq"
        1
        0
        "aeiou"
        0
        1
        "ieaouqqieaouqq"
        1
        3
        "iqeaouqi"
        2
        0
    """.trimIndent()
        .testcase()
        .zipWithNextN(3)
        .map {
            it.argumentSignature(
                ::removeQuote ,
                ::int ,
                ::long
            )
        }
        .forEach { ( f , s , ans ) ->

        }
}