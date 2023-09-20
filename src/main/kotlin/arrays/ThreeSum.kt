package arrays

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique
 * triplets in the array which gives the sum of zero.
 */
object ThreeSum {

    private fun twoSum(target: Int, list: List<Int>, index: Int): Pair<Int, Int>? {
        var start = index + 1
        var end = list.size - 1
        if (start >= end) return null
        var current = list[start] + list[end]
        while (current != target) {
            if (current > target) end--
            if (current < target) start++
            if (start >= end) return null
            current = list[start] + list[end]
        }
        return Pair(start, end)
    }

    fun threeSum(list: MutableList<Int>): HashSet<IntArray> {
        val result = hashSetOf<IntArray>()
        list.sort()
        for (i in 0 until list.size - 2) {
            val target = -list[i]
            val twoSum = twoSum(target, list, i)
            val row = intArrayOf(list[i], list[twoSum?.first ?: continue], list[twoSum.second])
            result.add(row)
        }
        return result
    }
}