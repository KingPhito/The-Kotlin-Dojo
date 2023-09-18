package arrays

object Primes {
    fun primes(n: Int): List<Int> {
        val result = mutableListOf<Int>()
        for (i in 2..n) result.add(i)
        var i = 0
        while (i < result.size) {
            result.removeIf { it != result[i] && it % result[i] == 0 }
            i++
        }
        return result
    }
}