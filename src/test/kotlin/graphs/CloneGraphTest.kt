package graphs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CloneGraphTest {

    @Test
    fun cloneGraphDFS() {
        val node1 = Node(1)
        val node2 = Node(2)
        val node3 = Node(3)
        val node4 = Node(4)
        node1.neighbors.add(node2)
        node1.neighbors.add(node4)
        node2.neighbors.add(node1)
        node2.neighbors.add(node3)
        node3.neighbors.add(node2)
        node3.neighbors.add(node4)
        node4.neighbors.add(node1)
        node4.neighbors.add(node3)
        val actual = CloneGraph.cloneGraphDFS(node1)
        assertEquals(node1.`val`, actual?.`val`)
        assertEquals(node1.neighbors.size, actual?.neighbors?.size)
        node1.neighbors.forEach { expectedNeighbor ->
            assertTrue(actual?.neighbors?.any { actualNeighbor ->
                expectedNeighbor?.`val` == actualNeighbor?.`val`
            } ?: false)
        }
    }

    @Test
    fun cloneGraphDFSRecursive() {
        val node1 = Node(1)
        val node2 = Node(2)
        val node3 = Node(3)
        val node4 = Node(4)
        node1.neighbors.add(node2)
        node1.neighbors.add(node4)
        node2.neighbors.add(node1)
        node2.neighbors.add(node3)
        node3.neighbors.add(node2)
        node3.neighbors.add(node4)
        node4.neighbors.add(node1)
        node4.neighbors.add(node3)
        val actual = CloneGraph.cloneGraphDFSRecursive(node1)
        assertEquals(node1.`val`, actual?.`val`)
        assertEquals(node1.neighbors.size, actual?.neighbors?.size)
        node1.neighbors.forEach { expectedNeighbor ->
            assertTrue(actual?.neighbors?.any { actualNeighbor ->
                expectedNeighbor?.`val` == actualNeighbor?.`val`
            } ?: false)
        }
    }

    @Test
    fun cloneGraphBFS() {
        val node1 = Node(1)
        val node2 = Node(2)
        val node3 = Node(3)
        val node4 = Node(4)
        node1.neighbors.add(node2)
        node1.neighbors.add(node4)
        node2.neighbors.add(node1)
        node2.neighbors.add(node3)
        node3.neighbors.add(node2)
        node3.neighbors.add(node4)
        node4.neighbors.add(node1)
        node4.neighbors.add(node3)
        val actual = CloneGraph.cloneGraphBFS(node1)
        assertEquals(node1.`val`, actual?.`val`)
        assertEquals(node1.neighbors.size, actual?.neighbors?.size)
        node1.neighbors.forEach { expectedNeighbor ->
            assertTrue(actual?.neighbors?.any { actualNeighbor ->
                expectedNeighbor?.`val` == actualNeighbor?.`val`
            } ?: false)
        }
    }

    @Test
    fun cloneGraphBFSRecursive() {
        val node1 = Node(1)
        val node2 = Node(2)
        val node3 = Node(3)
        val node4 = Node(4)
        node1.neighbors.add(node2)
        node1.neighbors.add(node4)
        node2.neighbors.add(node1)
        node2.neighbors.add(node3)
        node3.neighbors.add(node2)
        node3.neighbors.add(node4)
        node4.neighbors.add(node1)
        node4.neighbors.add(node3)
        val actual = CloneGraph.cloneGraphBFSRecursive(node1)
        assertEquals(node1.`val`, actual?.`val`)
        assertEquals(node1.neighbors.size, actual?.neighbors?.size)
        node1.neighbors.forEach { expectedNeighbor ->
            assertTrue(actual?.neighbors?.any { actualNeighbor ->
                expectedNeighbor?.`val` == actualNeighbor?.`val`
            } ?: false)
        }
    }
}