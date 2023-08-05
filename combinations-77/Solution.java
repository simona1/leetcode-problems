
/**
 * LeetCode problem # 77, 'Combinations'
 * https://leetcode.com/problems/combinations
 */

import java.util.*;

class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        solve(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    public void solve(int n, int k, int size, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
        }

        for (int i = size; i <= n; ++i) {
            list.add(i);
            solve(n, k, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}