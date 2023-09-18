package arrays

import org.junit.jupiter.api.Assertions.*

class ShortestDistanceTest {

        @org.junit.jupiter.api.Test
        fun shortestDistance() {
            val words = arrayOf("a", "c", "b", "b", "a")
            val word1 = "a"
            val word2 = "b"
            val expected = 1
            val actual = ShortestDistance.shortestDistance(words, word1, word2)
            assertEquals(expected, actual)
        }

        @org.junit.jupiter.api.Test
        fun shortestDistance2() {
            val words = arrayOf("a", "c", "b", "b")
            val word1 = "a"
            val word2 = "b"
            val expected = 2
            val actual = ShortestDistance.shortestDistance(words, word1, word2)
            assertEquals(expected, actual)
        }
}