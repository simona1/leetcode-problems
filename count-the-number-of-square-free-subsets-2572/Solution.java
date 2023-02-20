/*
 * LeetCode problem # 2572, 'Count the Number of Square-Free Subsets'
 * https://leetcode.com/problems/count-the-number-of-square-free-subsets/
 */

import java.util.*;

class Solution {
    static int[] primes = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
    static long mod = (long) Math.pow(10, 9) + 7;
    long res = 0;

    public int squareFreeSubsets(int[] nums) {
        res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (isSquareFree(num)) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        Stack<Integer> st = new Stack<>();
        List<Integer> keys = new ArrayList<>();
        for (Integer key : map.keySet()) {
            keys.add(key);
        }
        solve(keys, 0, st, map);
        int ones = map.getOrDefault(1, 0);
        while (ones-- > 0) {
            res *= 2;
            res %= mod;
        }
        return (int) res - 1;
    }

    public void solve(List<Integer> keys, int index, Stack<Integer> st, Map<Integer, Integer> fr) {
        if (index == keys.size()) {
            long curr = 1;
            for (int s : st) {
                curr *= fr.getOrDefault(s, 0);
                curr %= mod;

            }
            if (curr != 0) {
                System.out.println(st + ", " + curr);
            }
            res += curr;
            res %= mod;

            return;
        }
        int toConsider = keys.get(index);
        boolean hasConflicts = false;
        for (int n : st) {
            if (!isSquareFree(toConsider * n)) {
                hasConflicts = true;
                break;
            }
        }
        if (!hasConflicts && toConsider != 1) {
            st.push(toConsider);
            solve(keys, index + 1, st, fr);
            st.pop();
        }
        solve(keys, index + 1, st, fr);
    }

    public boolean isSquareFree(int n) {
        for (int p : primes) {
            if (n % (p * p) == 0) {
                return false;
            }
        }
        return true;
    }
}
