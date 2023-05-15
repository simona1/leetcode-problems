
/**
 * LeetCode problem # 1799, 'Maximize Score After N Operations'
 * https://leetcode.com/problems/maximize-score-after-n-operations/
 */

import java.util.*;

class Solution {
    private Map<String, Integer> cache;

    public int maxScore(int[] nums) {
        int n = nums.length;

        cache = new HashMap<>();
        return solve(nums, new boolean[n], n / 2);
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    private int solve(int arr[], boolean used[], int ops) {
        if (ops == 0) {
            return 0;
        }
        String key = Arrays.toString(used) + "-" + ops;
        Integer value = cache.get(key);
        if (value != null) {
            return value;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                if (!used[i] && !used[j]) {
                    used[i] = used[j] = true;
                    int curr = (ops * gcd(arr[i], arr[j])) + solve(arr, used, ops - 1);
                    max = Math.max(max, curr);
                    used[i] = used[j] = false;
                }
            }
        }
        cache.put(key, max);
        return max;
    }
}
