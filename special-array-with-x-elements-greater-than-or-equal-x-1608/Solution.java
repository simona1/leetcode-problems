
/**
 * LeetCode problem # 1608, 'Special Array With X Elements Greater Than or Equal
 * X'
 * https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
 */

class Solution {
    public int specialArray(int[] nums) {
        // lo <= res < high

        int n = nums.length;
        int lo = -1;
        int hi = n + 1;

        while (lo + 1 != hi) {
            int mid = lo + (hi - lo) / 2;
            int count = getCount(nums, mid);

            if (count >= mid) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return getCount(nums, lo) == lo ? lo : -1;
    }

    private int getCount(int[] nums, int lim) {
        int res = 0;

        for (int num : nums) {
            if (num >= lim) {
                ++res;
            }
        }
        return res;
    }
}
