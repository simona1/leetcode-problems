
/**
 * LeetCode problem # 1818, 'Minimum Absolute Sum Difference'
 * https://leetcode.com/problems/minimum-absolute-sum-difference/
 */

import java.util.*;

class Solution {
    static long MOD = 1000000007;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] sorted1 = nums1.clone();
        Arrays.sort(sorted1);
        int n = nums1.length;

        long totalDiff = 0;

        for (int i = 0; i < n; ++i) {
            totalDiff += Math.abs(nums1[i] - nums2[i]);
        }

        long res = totalDiff;

        for (int i = 0; i < n; ++i) {
            int currLeft = leftBound(sorted1, nums2[i]);
            int currRight = rightBound(sorted1, nums2[i]);

            int leftIndex = currLeft == n ? currLeft - 1 : currLeft;
            int rightIndex = currRight < 0 ? 0 : currRight;

            int diff = Math.min(Math.abs(nums2[i] - sorted1[leftIndex]), Math.abs(nums2[i] - sorted1[rightIndex]));

            res = Math.min(res, totalDiff - Math.abs(nums1[i] - nums2[i]) + diff);
        }
        return (int) (res % MOD);
    }

    public int rightBound(int[] nums, int val) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > val) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    public int leftBound(int[] nums, int val) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= val) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
