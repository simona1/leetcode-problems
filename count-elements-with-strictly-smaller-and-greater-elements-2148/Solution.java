
/**
 * LeetCode problem # 2148, 'Count Elements With Strictly Smaller and Greater
 * Elements'
 * https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/
 */

class Solution {
    public int countElements(int[] nums) {
        int n = nums.length;

        int res = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for (int i = 0; i < n; ++i) {
            if (nums[i] > min && nums[i] < max) {
                ++res;
            }
        }
        return res;
    }
}