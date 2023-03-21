
/**
 * LeetCode problem # 382, 'Linked List Random Node'
 * https://leetcode.com/problems/linked-list-random-node/
 */

import java.util.*;

class Solution {
    private List<Integer> values = new ArrayList<>();

    public Solution(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }
    }

    public int getRandom() {
        int rand = (int) (Math.random() * this.values.size());
        return this.values.get(rand);

    }
}
