package graphs

/**
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1,
 * and each room may have some keys to access the next room. Formally, each room i has a list of
 * keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.
 * A key rooms[i][j] = v opens the room with number v. Initially, all the rooms start locked
 * (except for room 0). You can walk back and forth between rooms freely. Write a function that returns
 * true if and only if you can enter every room.
 */
object KeysAndRooms {

    fun canVisitAllRoomsDFS(rooms: List<List<Int>>): Boolean {
        val seen = mutableSetOf<Int>()
        val stack = mutableListOf<Int>()
        stack.add(0)
        while (stack.isNotEmpty()) {
            val room = stack.removeAt(0)
            if (seen.contains(room)) continue
            seen.add(room)
            stack.addAll(rooms[room])
        }
        return seen.size == rooms.size
    }
}