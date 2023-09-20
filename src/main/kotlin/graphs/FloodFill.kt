package graphs

import java.awt.Point
import java.util.Stack

/**
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image
 * (from 0 to 65535).
 *
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel
 * value newColor, "flood fill" the image.
 *
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the
 * starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those
 * pixels (also with the same color as the starting pixel), and so on. Replace the color of all the
 * aforementioned pixels with the newColor.
 *
 * At the end, return the modified image.
 */
object FloodFill {

    fun floodFillDFS(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val oldColor = image[sr][sc]

        if (oldColor == color) return image

        val stack = Stack<Point>()
        stack.push(Point(sc, sr))

        while (stack.isNotEmpty()) {
            val pixel = stack.pop()

            if (pixel.x in image.indices && pixel.y in image.indices && image[pixel.x][pixel.y] == oldColor) {
                image[pixel.x][pixel.y] = color

                listOf(
                    Point(pixel.x+1, pixel.y),
                    Point(pixel.x-1, pixel.y),
                    Point(pixel.x, pixel.y+1),
                    Point(pixel.x, pixel.y-1)
                ).forEach { stack.push(it) }
            }
        }

        return image
    }

    fun floodFillDFSRecursive(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val oldColor = image[sr][sc]

        if (oldColor == color) return image

        tailrec fun dfs(sr: Int, sc: Int) {
            if (sr in image.indices && sc in image[0].indices && image[sr][sc] == oldColor) {
                image[sr][sc] = color

                dfs(sr+1, sc)
                dfs(sr-1, sc)
                dfs(sr, sc+1)
                dfs(sr, sc-1)
            }
        }

        dfs(sr, sc)

        return image
    }

    fun floodFillBFS(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val oldColor = image[sr][sc]

        if (oldColor == color) return image

        val queue = ArrayDeque<Point>()
        queue.add(Point(sr, sc))

        while (queue.isNotEmpty()) {
            val pixel = queue.removeFirst()

            if (pixel.x in image.indices && pixel.y in image.indices && image[pixel.x][pixel.y] == oldColor) {
                image[pixel.x][pixel.y] = color

                listOf(
                    Point(pixel.x + 1, pixel.y),
                    Point(pixel.x - 1, pixel.y),
                    Point(pixel.x, pixel.y + 1),
                    Point(pixel.x, pixel.y - 1)
                ).forEach { queue.add(it) }
            }
        }

        return image
    }
}