
/**
 * LeetCode problem # 2654, 'Minimum Number of Operations to Make All Array
 * Elements Equal to 1'
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/
 */

class Solution {

    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public int minOperations(int[] nums) {
        int n = nums.length;

        int ones = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                ++ones;
            }
        }
        if (ones > 0) {
            return n - ones;
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            int curr = nums[i];
            for (int j = i + 1; j < n; ++j) {
                curr = gcd(curr, nums[j]);
                if (curr == 1) {
                    res = Math.min(res, j - i);
                    break;
                }
            }
            if (curr != 1) {
                break;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : (n - 1 + res);
    }
}
