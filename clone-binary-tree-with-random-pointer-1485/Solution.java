/*
* LeetCode problem # 1485 'Clone Binary Tree With Random Pointer'
* https://leetcode.com/problems/clone-binary-tree-with-random-pointer
*/

import java.util.*;

/**
 * Definition for Node.
 */

class Node {
    int val;
    Node left;
    Node right;
    Node random;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node random) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = random;
    }
}

class NodeCopy {
    int val;
    NodeCopy left;
    NodeCopy right;
    NodeCopy random;

    public NodeCopy() {
    }

    public NodeCopy(int val) {
        this.val = val;
    }

    public NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = random;
    }
}

class Solution {
    private Map<Node, NodeCopy> vis = new HashMap<>();

    private NodeCopy traverse(Node root) {
        if (root == null) {
            return null;
        }

        NodeCopy rootCopy = vis.get(root);
        if (rootCopy != null) {
            return rootCopy;
        }

        rootCopy = new NodeCopy(root.val);

        vis.put(root, rootCopy);
        rootCopy.left = traverse(root.left);
        rootCopy.right = traverse(root.right);
        rootCopy.random = traverse(root.random);
        return rootCopy;
    }

    public NodeCopy copyRandomBinaryTree(Node root) {
        NodeCopy rootCopy = traverse(root);
        return rootCopy;
    }
}
