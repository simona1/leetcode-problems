
/**
 * LeetCode problem # 228, 'Summary Ranges'
 * https://leetcode.com/problems/summary-ranges
 */

import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<>();

        for (int i = 0, j = 0; i < nums.length; ++i) {
            if (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                continue;
            }
            if (i == j) {
                res.add(nums[j] + "");
            } else {
                res.add(nums[j] + "->" + nums[i]);
            }
            j = i + 1;
        }
        return res;
    }
}