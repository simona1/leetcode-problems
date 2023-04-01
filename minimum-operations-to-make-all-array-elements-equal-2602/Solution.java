
/**
 * LeetCode problem # 2602, 'Minimum Operations to Make All Array Elements Equal'
 * https://leetcode.com/problems/minimum-operations-to-make-all-array-elements-equal
 */

import java.util.*;

class Solution {

    private int binarySearch(int[] nums, int value) {
        int lo = -1;
        int hi = nums.length;

        while (lo + 1 != hi) {
            int mid = lo + (hi - lo) / 2;
            if (value >= nums[mid]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi;
    }

    public List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> res = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        long[] prefixSums = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        for (int q : queries) {
            int index = binarySearch(nums, q);
            long sum1 = 1L * q * index - prefixSums[index];
            long sum2 = prefixSums[n] - prefixSums[index] - (1L * (n - index) * q);
            res.add(sum1 + sum2);
        }
        return res;
    }
}
