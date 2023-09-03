
/**
 * LeetCode problem # 2366, 'Minimum Replacements to Sort the Array'
 * https://leetcode.com/problems/minimum-replacements-to-sort-the-array/
 */

class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long res = 0;

        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] <= nums[i + 1]) {
                continue;
            }
            long elementCount = (long) (nums[i] + nums[i + 1] - 1) / (long) nums[i + 1];
            res += elementCount - 1;
            nums[i] = nums[i] / (int) elementCount;
        }
        return res;
    }
}