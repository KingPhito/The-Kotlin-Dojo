package arrays

object ValidSudoku {
    fun validSudoku(board: Array<IntArray>): Boolean {
        val filled = hashSetOf<String>()

        for (x in 0 until board.size) {
            for (y in 0 until board[0].size) {
                val cell = board[x][y]
                if (cell == 0) continue

                val rowSig = "R${x}-$cell"
                val colSig = "C${y}-$cell"
                val gridSig = "GR${x/3}GC${y/3}-$cell"

                when {
                    !filled.add(rowSig) ||
                    !filled.add(colSig) ||
                    !filled.add(gridSig) -> return false
                }
            }
        }

        return true
    }
}