
/**
 * LeetCode problem # 2248, 'Intersection of Multiple Arrays'
 * https://leetcode.com/problems/intersection-of-multiple-arrays
 */

import java.util.*;

class Solution {
    public List<Integer> intersection(int[][] nums) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            int[] curr = nums[i];
            for (int j = 0; j < curr.length; ++j) {
                map.computeIfAbsent(curr[j], value -> new ArrayList<>()).add(i);
            }
        }

        List<Integer> res = new ArrayList<Integer>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == n) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
