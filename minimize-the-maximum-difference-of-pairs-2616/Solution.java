
/**
 * LeetCode problem # 2616, 'Minimize the Maximum Difference of Pairs'
 * https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/
 */

import java.util.*;

class Solution {
    private boolean isPair(int[] nums, int p, int diff) {
        int count = 0;
        int ptr = 1;
        
        while (ptr < nums.length) {
            if (nums[ptr] - nums[ptr - 1] <= diff) {
                ++count;
                ptr += 2;
            } else {
                ptr += 1;
            }
        }
        return count >= p;
    }

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;

        int low = 0;
        int high = nums[n - 1] - nums[0];

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isPair(nums, p, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}