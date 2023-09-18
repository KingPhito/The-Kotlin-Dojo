package arrays

import org.junit.jupiter.api.Assertions.*

class PrimesTest {

    @org.junit.jupiter.api.Test
    fun primes() {
        val expected = listOf(2, 3, 5, 7, 11, 13, 17, 19)
        val actual = Primes.primes(20)
        assertEquals(expected, actual)
    }
}