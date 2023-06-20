
/**
 * LeetCode problem # 2176, 'Count Equal and Divisible Pairs in an Array'
 * https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/
 */

class Solution {
    public int countPairs(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            int curr = nums[i];
            for (int j = 0; j < nums.length; ++j) {
                if ((i < j) && (curr == nums[j] && (i * j) % k == 0)) {
                    ++res;
                }
            }
        }
        return res;
    }
}