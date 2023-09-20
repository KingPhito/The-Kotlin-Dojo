package arrays

import kotlin.math.abs

/**
 * Given a list of words, and two words word1 and word2, return the shortest distance between these two words in the
 * list.
 */
object ShortestDistance {

    fun shortestDistance(words: Array<String>, word1: String, word2: String): Int {
        var shortest = Int.MAX_VALUE
        var index1 = -1
        var index2 = -1
        for (i in words.indices) {
            if (words[i] == word1) {
                index1 = i
                if (index2 != -1) shortest = shortest.coerceAtMost(abs(index1 - index2))
            } else if (words[i] == word2) {
                index2 = i
                if (index1 != -1) shortest = shortest.coerceAtMost(abs(index1 - index2))
            }
        }
        return shortest
    }
}