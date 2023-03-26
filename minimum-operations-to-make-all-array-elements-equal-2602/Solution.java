
/**
 * LeetCode problem # 2602, 'Minimum Operations to Make All Array Elements Equal'
 * https://leetcode.com/problems/minimum-operations-to-make-all-array-elements-equal
 */

import java.util.*;

class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> res = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        long[] prefixSum = new long[n + 1];

        for (int i = 0; i < n; ++i) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        for (int q : queries) {
            int index = binarySearch(nums, q);
            long left = 1L * q * index - prefixSum[index] + prefixSum[n] - prefixSum[index];
            long right = 1L * (n - index) * q;
            res.add(left - right);
        }
        return res;
    }

    private int binarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
