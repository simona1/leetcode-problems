
/**
 * LeetCode problem # 2210, 'Count Hills and Valleys in an Array'
 * https://leetcode.com/problems/count-hills-and-valleys-in-an-array
 */

class Solution {
    public int countHillValley(int[] nums) {

        int prev = nums[0];
        int res = 0;

        for (int i = 1; i < nums.length - 1; ++i) {
            if (isHill(prev, nums[i], nums[i + 1]) || isValley(prev, nums[i], nums[i + 1])) {
                ++res;
                prev = nums[i];
            }
        }
        return res;
    }

    private boolean isHill(int prev, int num, int next) {
        return num > prev && num > next;
    }

    private boolean isValley(int prev, int num, int next) {
        return num < prev && num < next;
    }
}
