/**
 * LeetCode problem # 1822, 'Sign of the Product of an Array'
 * https://leetcode.com/problems/sign-of-the-product-of-an-array
 */

class Solution {
    public int arraySign(int[] nums) {
        int res = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                res *= -1;
            }
        }
        return res;
    }
}
