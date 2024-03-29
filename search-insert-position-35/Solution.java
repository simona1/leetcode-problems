/**
 * LeetCode problem # 35, 'Search Insert Position'
 * https://leetcode.com/problems/search-insert-position
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = -1;
        int high = nums.length;

        while (low + 1 != high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }
}
