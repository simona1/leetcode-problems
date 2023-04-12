
/**
 * LeetCode problem # 34, 'Find First and Last Position of Element in Sorted
 * Array'
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int startIndex = insertIndex(nums, target - 0.5);
        int endIndex = insertIndex(nums, target + 0.5);
        if (startIndex >= nums.length || nums[startIndex] != target) {
            return new int[] { -1, -1 };
        }
        return new int[] { startIndex, endIndex - 1 };
    }

    private int insertIndex(int[] nums, double target) {
        int low = -1;
        int high = nums.length;

        while (low + 1 != high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] < target) {
                low = mid;
            } else if (nums[mid] > target) {
                high = mid;
            }

        }
        return high;
    }
}
