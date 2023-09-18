package graphs

import org.junit.jupiter.api.Assertions.*

class KeysAndRoomsTest {

        @org.junit.jupiter.api.Test
        fun canVisitAllRooms() {
            val rooms = listOf(
                listOf(1),
                listOf(2),
                listOf(3),
                listOf()
            )
            val expected = true
            val actual = KeysAndRooms.canVisitAllRooms(rooms)
            assertEquals(expected, actual)
        }

        @org.junit.jupiter.api.Test
        fun canVisitAllRooms2() {
            val rooms = listOf(
                listOf(1, 3),
                listOf(3, 0, 1),
                listOf(2),
                listOf(0)
            )
            val expected = false
            val actual = KeysAndRooms.canVisitAllRooms(rooms)
            assertEquals(expected, actual)
        }
}