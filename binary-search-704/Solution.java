/**
 * LeetCode problem # 704, 'Binary Search'
 * https://leetcode.com/problems/binary-search
 */

class Solution {
    public int binarySearch(int[] nums, int target) {
        int low = -1;
        int high = nums.length;
        while (low + 1 != high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return -1;
    }

    // without altering search, use index
    public int search(int[] nums, int target) {
        int low = -1;
        int high = nums.length;
        while (low + 1 != high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low >= 0 && nums[low] == target ? low : -1;
    }
}
