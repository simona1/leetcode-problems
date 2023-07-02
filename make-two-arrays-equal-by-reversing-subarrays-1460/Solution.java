
/**
 * LeetCode problem # 1460, 'Make Two Arrays Equal by Reversing Subarrays'
 * https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/
 */

import java.util.*;

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : target) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        for (int num : arr) {
            if (!m.containsKey(num)) {
                return false;
            }
            m.put(num, m.get(num) - 1);
            if (m.get(num) == 0) {
                m.remove(num);
            }
        }
        return m.size() == 0;
    }
}