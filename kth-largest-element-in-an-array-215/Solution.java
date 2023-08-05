
/**
 * LeetCode problem # 215, 'Kth Largest Element in an Array'
 * https://leetcode.com/problems/kth-largest-element-in-an-array
 */

import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();

    }
}