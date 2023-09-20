package arrays

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following
 * rules:
 *
 * 1. Each row must contain the digits 1-9 without repetition.
 * 2. Each column must contain the digits 1-9 without repetition.
 * 3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 *
 * 1. A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * 2. Only the filled cells need to be validated according to the mentioned rules.
 */
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