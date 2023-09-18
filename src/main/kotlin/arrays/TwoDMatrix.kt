package arrays

object TwoDMatrix {

    fun rotate2DMatrix(matrix: Array<IntArray>): Array<IntArray> {
        val lastIndex: Int = matrix.size - 1
        val rotations = lastIndex / 2
        for (rotation in 0..rotations) {
            for (i in rotation until lastIndex - rotation) {
                val top = matrix[rotation][i]
                val right = matrix[i][lastIndex - rotation]
                val bottom = matrix[lastIndex - rotation][lastIndex - i]
                val left = matrix[lastIndex - i][rotation]

                matrix[i][lastIndex-rotation] = top
                matrix[lastIndex-rotation][lastIndex-i] = right
                matrix[lastIndex-i][rotation] = bottom
                matrix[rotation][i] = left
            }
        }
        return matrix
    }
}