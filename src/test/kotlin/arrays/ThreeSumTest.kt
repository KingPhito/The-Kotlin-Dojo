package arrays

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ThreeSumTest {

    @Test
    fun threeSum() {
        val list = mutableListOf(-1, 0, 1, 2, -1, -4)
        val expected = listOf(
            listOf(-1, -1, 2),
            listOf(-1, 0, 1)
        )
        val actual = ThreeSum.threeSum(list)
        actual.forEach { row -> row.forEach { print("$it ") }; println() }
        assertEquals(expected.size, actual.size)
        assert(expected == actual)
    }

    @Test
    fun threeSum2() {
        val list = mutableListOf(0, 0, 0, 0)
        val expected = listOf(
            listOf(0, 0, 0)
        )
        val actual = ThreeSum.threeSum(list)
        actual.forEach { row -> row.forEach { print("$it ") }; println() }
        assertEquals(expected.size, actual.size)
        assert(expected == actual)
    }
}