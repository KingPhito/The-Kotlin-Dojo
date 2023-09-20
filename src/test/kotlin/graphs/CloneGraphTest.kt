package graphs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import graphs.CloneGraph.Node

class CloneGraphTest {

    private lateinit var node1: Node
    private lateinit var node2: Node
    private lateinit var node3: Node
    private lateinit var node4: Node

    @BeforeEach
    fun setup() {
        node1 = Node(1)
        node2 = Node(2)
        node3 = Node(3)
        node4 = Node(4)
        node1.neighbors.add(node2)
        node1.neighbors.add(node3)
        node2.neighbors.add(node1)
        node2.neighbors.add(node3)
        node3.neighbors.add(node2)
        node3.neighbors.add(node1)
        node4.neighbors.add(node1)
        node4.neighbors.add(node3)
    }

    @Test
    fun cloneGraphDFS() {
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
        val actual = CloneGraph.cloneGraphBFS(node1)
        assertEquals(node1.`val`, actual?.`val`)
        assertEquals(node1.neighbors.size, actual?.neighbors?.size)
        node1.neighbors.forEach { expectedNeighbor ->
            assertTrue(actual?.neighbors?.any { actualNeighbor ->
                expectedNeighbor?.`val` == actualNeighbor?.`val`
            } ?: false)
        }
    }
}