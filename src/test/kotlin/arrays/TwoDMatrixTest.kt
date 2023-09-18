package arrays

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TwoDMatrixTest {

    @Test
    fun rotate2DMatrix() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16)
        )
        val expected = arrayOf(
            intArrayOf(13, 9, 5, 1),
            intArrayOf(14, 10, 6, 2),
            intArrayOf(15, 11, 7, 3),
            intArrayOf(16, 12, 8, 4)
        )
        val actual = TwoDMatrix.rotate2DMatrix(matrix)
        actual.forEach { row -> row.forEach { print("$it ") }; println() }
        assertArrayEquals(expected, actual)
    }
}