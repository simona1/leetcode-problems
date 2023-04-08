
/**
 * LeetCode problem # 133, 'Clone Graph'
 * https://leetcode.com/problems/clone-graph
 */

import java.util.*;

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

class Solution {
    Map<Node, Node> vis = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        Node curr = vis.get(node);
        if (curr != null) {
            return curr;
        }

        Node cloned = new Node(node.val, new ArrayList<>());
        vis.put(node, cloned);

        for (Node neigh : node.neighbors) {
            cloned.neighbors.add(cloneGraph(neigh));
        }
        return cloned;
    }
}
