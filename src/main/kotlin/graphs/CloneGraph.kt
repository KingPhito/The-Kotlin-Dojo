package graphs

import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashMap

/**
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 */
data class Node(var `val`: Int, var neighbors: ArrayList<Node?> = ArrayList())


object CloneGraph {

    fun cloneGraphDFS(node: Node?): Node? {
        if (node == null) return null

        val clone = HashMap<Node, Node>()
        val stack = Stack<Node>()
        stack.push(node)

        while (stack.isNotEmpty()) {
            val current = stack.pop()

            if (!clone.contains(current)) {
                clone[current] = Node(current.`val`)
                for (neighbor in current.neighbors) {
                    neighbor?.let {
                        clone[it] = Node(it.`val`)
                        stack.push(it)
                    }
                }
            }

            for (neighbor in current.neighbors) {
                clone[current]?.neighbors?.add(clone[neighbor])
            }
        }

        return clone[node]
    }

    fun cloneGraphDFSRecursive(node: Node?): Node? {
        val clone = mutableMapOf<Node, Node>()
        return dfs(node, clone)
    }

    private fun dfs(node: Node?, clone: MutableMap<Node, Node>): Node? {
        return when {
            node == null -> null
            clone.contains(node) -> clone[node]
            else -> {
                clone[node] = Node(node.`val`)
                node.neighbors.forEach {
                    clone[node]?.neighbors?.add(dfs(it, clone))
                }
                clone[node]
            }
        }
    }

    fun cloneGraphBFS(node: Node?): Node? {
        if (node == null) return null

        val clone = mutableMapOf<Node, Node>()
        val queue = ArrayDeque<Node>()
        queue.addLast(node)

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()

            if (!clone.contains(current)) {
                clone[current] = Node(current.`val`)
                for (neighbor in current.neighbors) {
                    neighbor?.let {
                        queue.addLast(it)
                        clone[it] = Node(it.`val`)}
                }
            }

            for (neighbor in current.neighbors) {
                clone[current]?.neighbors?.add(clone[neighbor])
            }
        }

        return clone[node]
    }

    /**
     * This is a recursive solution to the BFS problem. It is not as efficient as the iterative solution.
     * It is included here for completeness. It is not tested in the unit tests because it can cause
     * stack overflow errors.
     */
    fun cloneGraphBFSRecursive(node: Node?): Node? {
        val clone = mutableMapOf<Node, Node>()
        return bfs(node, clone)
    }

    private fun bfs(node: Node?, clone: MutableMap<Node, Node>, queue: ArrayDeque<Node> = ArrayDeque()): Node? {
        if (node == null) return null

        clone[node] = Node(node.`val`)

        for (neighbor in node.neighbors) {
            neighbor?.let {
                queue.add(it)
            }
        }

        if (queue.isNotEmpty()) bfs(queue.removeFirst(), clone, queue)

        return clone[node]
    }
}