/**
 * LeetCode problem # 1060, 'Missing Element in Sorted Array'
 * https://leetcode.com/problems/missing-element-in-sorted-array/
 */

class Solution {
    public int missingElement(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;
        int mis = nums[hi] - nums[lo] - (hi - lo);

        if (k > mis) {
            // case when we need to extend to the right beyond numbers in nums
            return nums[hi] + (k - mis);
        }

        while (lo < hi - 1) {
            int mid = lo + (hi - lo) / 2;
            mis = nums[mid] - nums[lo] - (mid - lo);

            if (k > mis) {
                k -= mis;
                lo = mid;
            } else {
                hi = mid;
            }
        }
        // now it has been narrowed down
        return nums[lo] + k;

    }
}
