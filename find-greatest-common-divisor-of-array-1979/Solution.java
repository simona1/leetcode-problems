/**
 * LeetCode problem # 1979, 'Find Greatest Common Divisor of Array'
 * https://leetcode.com/problems/find-greatest-common-divisor-of-array/
 */

class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return gcd(max, min);
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
