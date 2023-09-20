package arrays

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ThreeSumTest {

    @Test
    fun threeSum() {
        val nums = listOf(-1, 0, 1, 2, -1, -4)
        val expected = listOf(
            listOf(-1, -1, 2),
            listOf(-1, 0, 1)
        )
        val actual = ThreeSum.threeSum(nums)
        assertEquals(expected.size, actual.size)
        assert(expected == actual)
    }

    @Test
    fun threeSum2() {
        val nums = listOf(0, 0, 0, 0)
        val expected = listOf(
            listOf(0, 0, 0)
        )
        val actual = ThreeSum.threeSum(nums)
        assertEquals(expected.size, actual.size)
        assert(expected == actual)
    }
}