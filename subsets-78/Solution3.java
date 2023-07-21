
/**
 * LeetCode problem # 78, 'Subsets'
 * https://leetcode.com/problems/subsets/
 */

import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        subsetsImpl(0, nums, curr, res);
        return res;
    }

    private void subsetsImpl(int index, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(curr));
        } else {
            curr.add(nums[index]);
            subsetsImpl(index + 1, nums, curr, res);
            curr.remove(curr.size() - 1);
            subsetsImpl(index + 1, nums, curr, res);
        }
    }
}