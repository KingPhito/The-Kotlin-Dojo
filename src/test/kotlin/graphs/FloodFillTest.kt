package graphs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FloodFillTest {

    @Test
    fun floodFillDFS() {
        val image = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1)
        )
        val sr = 1
        val sc = 1
        val newColor = 2
        val expected = arrayOf(
            intArrayOf(2, 2, 2),
            intArrayOf(2, 2, 0),
            intArrayOf(2, 0, 1)
        )
        val actual = FloodFill.floodFillDFS(image, sr, sc, newColor)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun floodFillDFSRecursive() {
        val image = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1)
        )
        val sr = 1
        val sc = 1
        val newColor = 2
        val expected = arrayOf(
            intArrayOf(2, 2, 2),
            intArrayOf(2, 2, 0),
            intArrayOf(2, 0, 1)
        )
        val actual = FloodFill.floodFillDFSRecursive(image, sr, sc, newColor)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun floodFillBFS() {
        val image = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1)
        )
        val sr = 1
        val sc = 1
        val newColor = 2
        val expected = arrayOf(
            intArrayOf(2, 2, 2),
            intArrayOf(2, 2, 0),
            intArrayOf(2, 0, 1)
        )
        val actual = FloodFill.floodFillBFS(image, sr, sc, newColor)
        assertArrayEquals(expected, actual)
    }
}