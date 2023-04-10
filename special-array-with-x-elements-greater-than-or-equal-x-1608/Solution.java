
/**
 * LeetCode problem # 1608, 'Special Array With X Elements Greater Than or Equal X'
 * https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x
 */

import java.util.*;

class Solution {
    public int specialArray(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;
        int lo = -1;
        int hi = n;

        while (lo + 1 != hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] >= n - mid && (mid == 0 || n - mid > nums[mid - 1])) {
                return n - mid;
            } else if (nums[mid] < n - mid) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return -1;
    }
}