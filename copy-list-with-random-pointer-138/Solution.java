
/**
 * LeetCode problem # 138, 'Copy List with Random Pointer'
 * https://leetcode.com/problems/copy-list-with-random-pointer
 */

import java.util.*;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> visited = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node old = head;
        Node oldCopy = new Node(old.val);
        this.visited.put(old, oldCopy);

        while (old != null) {
            oldCopy.random = this.getClonedNode(old.random);
            oldCopy.next = this.getClonedNode(old.next);

            old = old.next;
            oldCopy = oldCopy.next;
        }
        return this.visited.get(head);
    }

    public Node getClonedNode(Node node) {
        if (node != null) {
            Node fromVisited = this.visited.get(node);

            if (fromVisited == null) {
                fromVisited = new Node(node.val);
                this.visited.put(node, fromVisited);
            }
            return fromVisited;
        }
        return null;
    }
}