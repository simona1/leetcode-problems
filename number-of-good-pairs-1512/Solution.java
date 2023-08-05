
/**
 * LeetCode problem # 1512, 'Number of Good Pairs'
 * https://leetcode.com/problems/number-of-good-pairs/
 */

import java.util.*;

class Solution {
    public int numIdenticalPairs(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer val : map.values()) {
            res += val * (val - 1) / 2;
        }
        return res;
    }

}