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
    private HashMap<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        } 
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node newNode = new Node(node.val, new ArrayList<Node>()); // Deep Copy.
        map.put(node.val, newNode); // Deep Copy.
        for (Node neighbor : node.neighbors) { // for every neighbour of a given vertex in the given graph.
            newNode.neighbors.add(cloneGraph(neighbor)); // add the neighbors to the list.
        }
        return newNode;
    }
}
