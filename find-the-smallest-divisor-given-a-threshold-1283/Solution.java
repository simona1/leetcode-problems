/**
 * LeetCode problem # 1283, 'Find the Smallest Divisor Given a Threshold'
 * https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold
 */

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int res = -1;

        int maxNum = nums[0];
        for (int num : nums) {
            maxNum = Math.max(num, maxNum);
        }

        int low = 0;
        int high = maxNum + 1;

        while (low + 1 != high) {
            int mid = (low + high) / 2;
            int curr = sumDivided(nums, mid);
            if (curr <= threshold) {
                res = mid;
                high = mid;
            } else {
                low = mid;
            }
        }
        return res;
    }

    private int sumDivided(int[] nums, int div) {
        int res = 0;
        for (int num : nums) {
            res += Math.ceil((num * 1.0) / div);
        }
        return res;
    }
}
