
/**
 * LeetCode problem # 465, 'Optimal Account Balancing'
 * https://leetcode.com/problems/optimal-account-balancing/
 */

import java.util.*;

class Solution {
    int res = 0;

    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        res = transactions.length;

        for (int[] tr : transactions) {
            map.put(tr[0], map.getOrDefault(tr[0], 0) - tr[2]);
            map.put(tr[1], map.getOrDefault(tr[1], 0) + tr[2]);
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i : map.values()) {
            if (i > 0) {
                list1.add(i);
            } else if (i < 0) {
                list2.add(-i);
            }
        }
        backtrack(list1, list2, 0);
        return res;
    }

    private void backtrack(List<Integer> list1, List<Integer> list2, int p) {
        if (p >= res) {
            return;
        }
        if (list1.isEmpty()) {
            res = Math.min(p, res);
            return;
        }
        int n1 = list1.size();
        int n2 = list2.size();

        if (p + n1 >= res || p + n2 >= res) {
            return;
        }
        for (int i = 0; i < n1; ++i) {
            int v1 = list1.remove(i);
            for (int j = 0; j < n2; ++j) {
                int v2 = list2.remove(j);
                if (v1 > v2) {
                    list1.add(v1 - v2);
                    backtrack(list1, list2, p + 1);
                    list1.remove(list1.size() - 1);
                } else if (v1 < v2) {
                    list2.add(v2 - v1);
                    backtrack(list1, list2, p + 1);
                    list2.remove(list2.size() - 1);
                } else {
                    backtrack(list1, list2, p + 1);
                }
                list2.add(j, v2);
            }
            list1.add(i, v1);
        }
        return;
    }
}
