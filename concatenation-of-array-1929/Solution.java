
/**
 * LeetCode problem # 1929, 'Concatenation of Array'
 * https://leetcode.com/problems/concatenation-of-array/
 */

class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length * 2];
        int j = nums.length;

        for (int i = 0; i < nums.length; ++i) {
            res[i] = nums[i];
            res[j] = nums[i];
            ++j;
        }
        return res;
    }
}