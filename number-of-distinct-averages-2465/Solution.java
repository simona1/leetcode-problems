
/**
 * LeetCode problem #  2465, 'Number of Distinct Average'
 * https://leetcode.com/problems/number-of-distinct-averages
 */

import java.util.*;

class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;
        Set<Double> avg = new HashSet<>();

        while (i < j) {
            avg.add((nums[i++] + nums[j--]) / 2.0);
        }
        return avg.size();
    }
}
