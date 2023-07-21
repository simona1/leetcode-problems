
/**
 * LeetCode problem # 78, 'Subsets'
 * https://leetcode.com/problems/subsets/
 */

import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return generateAllSubsets(nums.length, nums);
    }

    private List<List<Integer>> generateAllSubsets(int n, int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int size = 1 << n;

        for (int i = 0; i < size; ++i) {
            List<Integer> curr = new ArrayList<>();

            for (int j = 0; j < n; ++j) {
                int bitmask = 1 << j;
                if ((i & bitmask) != 0) {
                    curr.add(nums[j]);
                }
            }
            res.add(curr);
        }
        return res;
    }
}
