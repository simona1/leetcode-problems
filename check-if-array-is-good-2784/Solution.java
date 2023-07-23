
/**
 * LeetCode problem # 2784, 'Check if Array is Good'
 * https://leetcode.com/problems/check-if-array-is-good/
 */

import java.util.*;

class Solution {
    public boolean isGood(int[] nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            max = Math.max(num, max);
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > 1 && num != max) {
                return false;
            }
        }

        if (map.get(max) != 2) {
            return false;
        }
        return nums.length == max + 1;

    }
}