
/**
 * LeetCode problem # 2616, 'Minimize the Maximum Difference of Pairs'
 * https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/
 */

import java.util.*;

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;

        int low = 0;
        int high = nums[n - 1] - nums[0];

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canGetPairs(nums, p, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canGetPairs(int[] nums, int p, int diff) {
        int count = 0;

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start + 1] - nums[start] <= diff) {
                ++count;
                start += 2;
            } else {
                start++;
            }
        }
        return count >= p;
    }
}