package arrays

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique
 * triplets in the array which gives the sum of zero.
 */
object ThreeSum {

    private fun twoSum(target: Int, nums: List<Int>, s: Int): List<Pair<Int, Int>> {
        var start = s
        var end = nums.size - 1

        val result = mutableListOf<Pair<Int, Int>>()

        while (start < end) {
            val sum = nums[start] + nums[end]
            if (sum == target) result.add(Pair(nums[start], nums[end]))
            if (sum > target) end-- else start++
        }

        return result
    }

    fun threeSum(list: List<Int>): List<List<Int>> {
        val result = hashSetOf<List<Int>>()
        val sorted = list.sorted()

        sorted.forEachIndexed { i, n ->
            twoSum(0-n, sorted, i+1).forEach {
                result.add(listOf(n, it.first, it.second))
            }
        }

        return result.toList()
    }
}