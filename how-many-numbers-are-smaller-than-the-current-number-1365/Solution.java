
/**
 * LeetCode problem # 1365, 'How Many Numbers Are Smaller Than the Current Number'
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */

import java.util.*;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[n];

        int index = 0;
        int[] numsCopy = Arrays.copyOf(nums, n);
        Arrays.sort(numsCopy);

        for (int i = 0; i < n; ++i) {
            if (!map.containsKey(numsCopy[i])) {
                map.put(numsCopy[i], i);
            }
        }

        for (int i = 0; i < n; ++i) {
            res[index++] = map.get(nums[i]);
        }
        return res;
    }
}
