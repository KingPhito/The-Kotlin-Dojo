package graphs

object KeysAndRooms {

    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
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