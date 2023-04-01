
/**
 * LeetCode problem # 2154, 'Keep Multiplying Found Values by Two'
 * https://leetcode.com/problems/keep-multiplying-found-values-by-two
 */

import java.util.*;

class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        int res = original;

        while (true) {
            int index = binarySearch(nums, res);
            if (index != -1) {
                res *= 2;
            } else {
                break;
            }
        }
        return res;
    }

    private int binarySearch(int[] nums, int target) {
        int lo = -1;
        int hi = nums.length;

        while (lo + 1 != hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return (lo >= 0 && nums[lo] == target) ? lo : -1;
    }
}
