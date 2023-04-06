
/**
 * LeetCode problem # 1005, 'Maximize Sum Of Array After K Negations'
 * https://leetcode.com/problems/maximize-sum-of-array-after-k-negations
 */

import java.util.*;

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length && k > 0; ++i) {
            if (nums[i] < 0) {
                --k;
                nums[i] *= -1;
            }
        }

        if (k % 2 != 0) {
            Arrays.sort(nums);
            nums[0] *= -1;
        }
        int res = 0;
        for (int num : nums) {
            res += num;
        }
        return res;
    }
}
