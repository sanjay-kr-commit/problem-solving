fun main() {

    """
        [7,1,7,2,2,4]
        [1,3,7]
    """.trimIndent()
        .split( "\n" )
        .groupInto(1)
        .appendResult( "8" , "7" )
        .recordState {
            forEach {
                it.solution(
                    "largestRectangleArea",
                    IntArray::class.java to ::intArray,
                ) {
                    timeTaken {
                        it()
                    }
                }
                    .index
                    .showDifference()
                    .coloredOutput(int(it.last()))
//                    .also(::println)
            }
            logReport
        }

}