
/**
 * LeetCode problem # 559, 'Maximum Depth of N-ary Tree'
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 */

import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; ++i) {
                Node curr = q.remove();
                if (curr.children != null) {
                    for (int j = 0; j < curr.children.size(); ++j) {
                        q.add(curr.children.get(j));
                    }
                }
            }
            ++count;
        }
        return count;
    }
}
