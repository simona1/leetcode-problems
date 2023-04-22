
/**
 * LeetCode problem # 611, 'Valid Triangle Number'
 * https://leetcode.com/problems/valid-triangle-number/
 */

import java.util.*;

class Solution {
    public int triangleNumber(int[] nums) {
        // a + b > c

        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;

        for (int i = nums.length - 1; i >= 2; --i) {
            int a = 0;
            int b = i - 1;

            while (a < b) {
                if (nums[a] + nums[b] > nums[i]) {
                    res += b - a;
                    --b;
                } else {
                    ++a;
                }
            }
        }
        return res;
    }
}
