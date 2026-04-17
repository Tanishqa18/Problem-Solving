import java.util.*;

class Solution {
    
    private HashMap<Node, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return dfs(node);
    }
    
    private Node dfs(Node node) {
    
        if (map.containsKey(node)) {
            return map.get(node);
        }
   
        Node clone = new Node(node.val);
        map.put(node, clone);
        
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor));
        }
        
        return clone;
    }
}
