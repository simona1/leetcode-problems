
/**
 * LeetCode problem # 2980, 'Check if Bitwise OR Has Trailing Zeros'
 * https://leetcode.com/problems/check-if-bitwise-or-has-trailing-zeros
 */

class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; ++i) {
            if (nums[i] % 2 == 0) {
                ++count;
            }
        }

        return count > 1;
    }
}

/*
 * Note: Even numbers in binary will end in zero
 */