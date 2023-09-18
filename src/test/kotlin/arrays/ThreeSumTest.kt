package arrays

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ThreeSumTest {

    @Test
    fun threeSum() {
        val list = mutableListOf(-1, 0, 1, 2, -1, -4)
        val expected = setOf(
            intArrayOf(-1, -1, 2),
            intArrayOf(-1, 0, 1)
        )
        val actual = ThreeSum.threeSum(list)
        actual.forEach { row -> row.forEach { print("$it ") }; println() }
        assertEquals(expected.size, actual.size)
        expected.forEach { expectedRow ->
            assertTrue(actual.any { actualRow ->
                expectedRow.contentEquals(actualRow)
            })
        }
    }

    @Test
    fun threeSum2() {
        val list = mutableListOf(0, 0, 0, 0)
        val expected = setOf(
            intArrayOf(0, 0, 0)
        )
        val actual = ThreeSum.threeSum(list)
        actual.forEach { row -> row.forEach { print("$it ") }; println() }
        assertEquals(expected.size, actual.size)
        expected.forEach { expectedRow ->
            assertTrue(actual.any { actualRow ->
                expectedRow.contentEquals(actualRow)
            })
        }
    }
}