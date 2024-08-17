class Solution {
    fun minElements(nums: IntArray, limit: Int, goal: Int): Int {
        val sum : Long = nums.sumOf { it.toLong() }
        var diff : Long = goal - sum
        if ( diff < 0 ) diff *= -1
        return if ( diff % limit == 0L ) (diff/limit).toInt() else ((diff/limit)+1).toInt()
    }
}