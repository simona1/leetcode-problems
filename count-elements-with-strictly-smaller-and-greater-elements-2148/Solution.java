
/**
 * LeetCode problem # 2148, 'Count Elements With Strictly Smaller and Greater
 * Elements'
 * https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/
 */

import java.util.*;

class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (key > nums[0] && key < nums[n - 1]) {
                res += map.get(key);
            }
        }
        return res;
    }
}
