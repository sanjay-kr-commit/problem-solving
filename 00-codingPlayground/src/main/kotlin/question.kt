import kotlin.math.max
import kotlin.math.min

fun solve(
    arr: IntArray, k: Int, index: Int,
    maxSum: Int, ans: IntArray
) {
    var maxSum = maxSum
    val n = arr.size
    var sum = 0
    if (k == 1) {
        for (i in index..<n) sum += arr[i]
        maxSum = max(maxSum.toDouble(), sum.toDouble()).toInt()
        ans[0] = min(ans[0].toDouble(), maxSum.toDouble()).toInt()
        return
    }

    for (i in index..<n) {
        sum += arr[i]
        maxSum = max(maxSum.toDouble(), sum.toDouble()).toInt()
        solve(arr, k - 1, i + 1, maxSum, ans)
    }
}

fun finMinSumOfMaxOfSubarray(arr: IntArray, n : Int, m: Int): Int {
    val ans = intArrayOf(Int.MAX_VALUE)
    solve(arr, m, 0, 0, ans)
    return ans[0]
}

fun createMatrix( n : Int ) : Array<IntArray> {
    val matrix = Array(5) { IntArray(5) { 0 } }
    val dis = n/5
    val rem = n % 5
    if ( rem != 0 ) for ( i in 0 until 5 ) matrix[i][i] = dis+rem
    for ( i in 0 until 5 ) {
        for ( j in 0 until 5 ) {
            if ( matrix[i][j] != 0 ) continue ;
            matrix[i][j] = dis ;
        }
    }
    return matrix
}

fun main() {
    finMinSumOfMaxOfSubarray(intArrayOf(10,3,5,7,1,4,8), 7 , 3 )
        .also(::println)

    println()
    finMinSumOfMaxOfSubarray(intArrayOf(1,3,2,4,5), 5 , 2 )
        .also(::println)



    """
        
        
        
    """.trimIndent()
        .also(::println)
    createMatrix( 15 )
        .forEach {
            it.forEach {
                print( "$it ," )
            }
            println()
        }
    println()

    createMatrix( 25 )
        .forEach {
            it.forEach {
                print( "$it ," )
            }
            println()
        }
    println()

    createMatrix( 35 )
        .forEach {
            it.forEach {
                print( "$it ," )
            }
            println()
        }

    println()

    createMatrix( 17 )
        .forEach {
            it.forEach {
                print( "$it ," )
            }
            println()
        }

}
