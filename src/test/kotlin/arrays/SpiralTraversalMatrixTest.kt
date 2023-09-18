package arrays

import org.junit.jupiter.api.Assertions.*

class SpiralTraversalMatrixTest {

    @org.junit.jupiter.api.Test
    fun spiralTraversal() {
        val matrix = arrayOf(
            arrayOf(1, 2, 3, 4, 5),
            arrayOf(6, 7, 8, 9, 10),
            arrayOf(11, 12, 13, 14, 15),
            arrayOf(16, 17, 18, 19, 20)
        )
        val expected = listOf(1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12)
        val actual = SpiralTraversalMatrix.spiralTraversal(matrix)
        assertEquals(expected, actual)
    }
}