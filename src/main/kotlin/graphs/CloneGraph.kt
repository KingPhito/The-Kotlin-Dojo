package graphs

import graphs.CloneGraph.Node

/**
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 */

object CloneGraph {

    class Node(var `val`: Int, var neighbors: MutableList<Node?> = mutableListOf())

    fun cloneGraphDFS(node: Node?): Node? {
        if (node == null) return null

        val clone = mutableMapOf<Node, Node>()
        val stack = ArrayDeque<Node>()
        stack.add(node)

        while (stack.isNotEmpty()) {
            val current = stack.removeLast()
            if (!clone.contains(current)) clone[current] = Node(current.`val`)
            current.neighbors.filterNotNull().forEach {
                if (!clone.contains(it)) {
                    clone[it] = Node(it.`val`)
                    stack.add(it)
                }
                clone[current]?.neighbors?.add(clone[it])
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
            if (!clone.contains(current)) clone[current] = Node(current.`val`)
            current.neighbors.filterNotNull().forEach {
                if (!clone.contains(it)) {
                    clone[it] = Node(it.`val`)
                    queue.add(it)
                }
                clone[current]?.neighbors?.add(clone[it])
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