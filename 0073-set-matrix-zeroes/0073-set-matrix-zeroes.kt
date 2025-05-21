class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        val array = BooleanArray(matrix.size + matrix[0].size) { false }
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[i].size) {
                array[i] = array[i] || matrix[i][j] == 0
                array[j + matrix.size] = array[j + matrix.size] || matrix[i][j] == 0
            }
        }
        for (i in 0 until matrix.size) {
            if (array[i]) {
                for (j in 0 until matrix[i].size) {
                    matrix[i][j] = 0
                }
            }
        }
        for (i in matrix.size until array.size) {
            if (array[i]) {
                for (j in 0 until matrix.size) {
                    matrix[j][i - matrix.size] = 0
                }
            }
        }
    }
}