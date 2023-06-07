
/**
 * LeetCode problem # 2395, 'Find Subarrays With Equal Sum'
 * https://leetcode.com/problems/find-subarrays-with-equal-sum/
 */

import java.util.*;

class Solution {
    public boolean findSubarrays(int[] nums) {

        int n = nums.length;
        Set<Integer> sums = new HashSet<>();
        for (int i = 1; i < n; ++i) {
            int currSum = nums[i] + nums[i - 1];
            if (sums.contains(currSum)) {
                return true;
            }
            sums.add(currSum);
        }
        return false;
    }
}
