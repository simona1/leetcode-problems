
/**
 * LeetCode problem # 2740, 'Find the Value of the Partition'
 * https://leetcode.com/problems/find-the-value-of-the-partition/
 */

import java.util.*;

class Solution {
    public int findValueOfPartition(int[] nums) {

        Arrays.sort(nums);

        int smallest = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; ++i) {
            int currDiff = nums[i] - nums[i - 1];
            if (currDiff < smallest) {
                smallest = currDiff;
            }
        }
        return smallest;
    }
}