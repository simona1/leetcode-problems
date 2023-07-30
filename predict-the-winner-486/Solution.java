
/**
 * LeetCode problem # 486, 'Predict the Winner'
 * https://leetcode.com/problems/predict-the-winner/
 */

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return findLargestDifference(nums, 0, nums.length - 1) >= 0;

    }

    private int findLargestDifference(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int chooseLeft = nums[left] - findLargestDifference(nums, left + 1, right);
        int chooseRight = nums[right] - findLargestDifference(nums, left, right - 1);

        return Math.max(chooseLeft, chooseRight);
    }
}