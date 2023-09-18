package graphs

import java.util.*

class Node(var `val`: Int) {
    var neighbors = mutableListOf<Node?>()
}

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

    fun cloneGraphBFSRecursive(node: Node?): Node? {
        val clone = mutableMapOf<Node, Node>()
        return bfs(node, clone)
    }

    private fun bfs(node: Node?, clone: MutableMap<Node, Node>): Node? {
        if (node == null) return null

        clone[node] = Node(node.`val`)

        for (neighbor in node.neighbors) {
            if (!clone.contains(neighbor) && neighbor != null) {
                clone[neighbor] = Node(neighbor.`val`)
                bfs(neighbor, clone)
            }
            clone[node]?.neighbors?.add(clone[neighbor])
        }

        return clone[node]
    }
}