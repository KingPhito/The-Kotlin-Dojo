package arrays

object SpiralTraversalMatrix {

    fun spiralTraversal(matrix: Array<Array<Int>>): List<Int> {
        val result = mutableListOf<Int>()
        val rows = matrix.size
        val cols = matrix.first().size

        if (rows < 2) return matrix.first().asList()
        if (cols < 2) {
            matrix.forEach { result.add(it.first()) }
            return result
        }

        result.addAll(matrix[0])
        for (i in 1 until rows) {
            result.add(matrix[i][cols - 1])
        }
        for (i in cols-2 downTo 0) {
            result.add(matrix[rows - 1][i])
        }
        for (i in rows-2 downTo 1) {
            result.add(matrix[i][0])
        }

        val subMatrix = mutableListOf<Array<Int>>()
        matrix.slice(1 until rows-1).forEach {
            subMatrix.add(it.slice(1 until cols-1).toTypedArray())
        }
        if (subMatrix.isEmpty()) return result
        result.addAll(spiralTraversal(subMatrix.toTypedArray()))
        return result
    }
}