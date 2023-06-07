
/**
 * LeetCode problem # 2717, 'Semi-Ordered Permutation'
 * https://leetcode.com/problems/semi-ordered-permutation/
 */

class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int indexOfFirst = 0;
        int indexOfLast = n - 1;

        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                indexOfFirst = i;
            }
            if (nums[i] == n) {
                indexOfLast = i;
            }
        }
        int res = indexOfFirst + n - 1 - indexOfLast;
        if (indexOfLast < indexOfFirst) {
            --res;
        }
        return res;

    }
}