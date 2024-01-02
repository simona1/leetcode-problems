/**
 * LeetCode problem # 2974, 'Minimum Number Game'
 * https://leetcode.com/problems/minimum-number-game
 */

import java.util.*;

class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);

        int i = 0;
        while (i < nums.length) {
            swap(nums, i, i + 1);
            i += 2;
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
