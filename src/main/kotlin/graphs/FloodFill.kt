package graphs

import java.awt.Point

object FloodFill {

    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val oldColor = image[sr][sc]

        if (oldColor == color) return image

        tailrec fun dfsFill(sr: Int, sc: Int) {
            if (sr in image.indices && sc in image[0].indices && image[sr][sc] == oldColor) {
                image[sr][sc] = color

                dfsFill(sr+1, sc)
                dfsFill(sr-1, sc)
                dfsFill(sr, sc+1)
                dfsFill(sr, sc-1)
            }
        }

        dfsFill(sr, sc)

        return image
    }

    fun floodFillBFS(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val oldColor = image[sr][sc]

        if (oldColor == color) return image

        val queue = mutableListOf<Point>()
        queue.add(Point(sr, sc))

        while (queue.isNotEmpty()) {
            val point = queue.removeAt(0)
            image[point.x][point.y] = color

            val up = Point(point.x+1, point.y)
            val down = Point(point.x-1, point.y)
            val left = Point(point.x, point.y-1)
            val right = Point(point.x, point.y+1)

            if (needsFill(image, up, oldColor)) queue.add(up)
            if (needsFill(image, down, oldColor)) queue.add(down)
            if (needsFill(image, left, oldColor)) queue.add(left)
            if (needsFill(image, right, oldColor)) queue.add(right)
        }

        return image
    }

    private fun needsFill(image: Array<IntArray>, point: Point, oldColor: Int): Boolean {
        return point.x in image.indices && point.y in image[0].indices && image[point.x][point.y] == oldColor
    }
}