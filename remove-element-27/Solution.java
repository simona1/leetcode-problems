/**
 * LeetCode problem # 27, 'Remove Element'
 * https://leetcode.com/problems/remove-element/
 */

class Solution {
    private void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == val) {
                ++count;
            }
        }
        int j = nums.length - 1;
        for (int i = 0; i < nums.length - count; ++i) {
            if (nums[i] == val) {
                while (nums[j] == val) {
                    --j;
                }
                swap(i, j, nums);
            }
        }
        return nums.length - count;
    }
}
