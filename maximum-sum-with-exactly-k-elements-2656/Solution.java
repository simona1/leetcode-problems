
/**
 * LeetCode problem # 2656, 'Maximum Sum With Exactly K Elements'
 * https://leetcode.com/problems/maximum-sum-with-exactly-k-elements
 */

import java.util.*;

class Solution {
    public int maximizeSum(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            pq.add(num);
        }

        int res = 0;
        for (int i = 0; i < k; ++i) {
            int curr = pq.remove();
            res += curr;
            pq.add(curr + 1);
        }
        return res;
    }
}
