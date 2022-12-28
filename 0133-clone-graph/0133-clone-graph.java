/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> q = new LinkedList();
        Map<Integer, Node> newNodes = new HashMap<>();

        q.add(node);
        newNodes.put(node.val, new Node(node.val));
        while (!q.isEmpty()) {
            Node temp = q.poll();
            Node copy = newNodes.get(temp.val);

            for (Node neighbor : temp.neighbors) {
                Node newNode = null;
                if (newNodes.containsKey(neighbor.val)) {
                    newNode = newNodes.get(neighbor.val);
                } else {
                    newNode = new Node(neighbor.val);
                    newNodes.put(newNode.val, newNode);
                    q.add(neighbor);
                }
                copy.neighbors.add(newNode);
            }
        }
        return newNodes.get(node.val);
    }
}