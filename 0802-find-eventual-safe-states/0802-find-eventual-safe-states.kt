class Solution {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val reverseGraph = Array(graph.size) { mutableListOf<Int>() }
        val outDegree = IntArray(graph.size)

        val queue = ArrayDeque<Int>()
        for (i in graph.indices) {
            for (neighbor in graph[i]) {
                reverseGraph[neighbor].add(i)
            }
            outDegree[i] = graph[i].size
            if (outDegree[i] == 0) {
                queue.add(i)
            }
        }

        val result = mutableListOf<Int>()
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            result.add(node)

            for (prev in reverseGraph[node]) {
                outDegree[prev]--
                if (outDegree[prev] == 0) {
                    queue.add(prev)
                }
            }
        }
        return result.sorted()
    }
}
