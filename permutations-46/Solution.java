
/**
 * LeetCode problem # 46, 'Permutations'
 * https://leetcode.com/problems/permutations/
 */

import java.util.*;

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        solve(nums, nums.length, new ArrayList<>(), vis, res);
        return res;
    }

    void solve(int[] nums, int k, List<Integer> list, boolean[] vis, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < k; ++i) {
            if (vis[i]) {
                continue;
            }

            list.add(nums[i]);
            vis[i] = true;
            solve(nums, k, list, vis, res);

            list.remove(list.size() - 1);
            vis[i] = false;
        }
    }
}