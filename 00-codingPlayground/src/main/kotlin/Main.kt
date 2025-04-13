import kotlin.time.measureTime
fun main() {

    operator fun <T> T.invoke() : T = also(::println)

    var index = 0
    """
        1
        100
        1200
        1230
    """.trimIndent()
        .split('\n')
        .groupInto(1)
        .appendResult( "5","2","0","5470" )
        .forEach ( 1 ) {
            "countGoodNumbers" <Int> ( it ) {
                long
                callSite {
                    measureTime {
                        it()
                    }()
                }
            }()
        }

}