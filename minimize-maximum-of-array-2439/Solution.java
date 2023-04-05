/**
 * LeetCode problem # 2439, 'Minimize Maximum of Array'
 * https://leetcode.com/problems/minimize-maximum-of-array/
 */

import java.util.*;

class Solution {
    public int minimizeArrayValue(int[] nums) {
        long res = nums[0];
        long sum = nums[0];  

        for (int i = 1; i < nums.length; ++i) {
            sum += nums[i];
            long avg = sum % (i + 1) == 0 ? sum / (i + 1) : sum / (i + 1) + 1;
            res = Math.max(res, avg);
        }
        return (int) res;
    }
}
