
/**
 * LeetCode problem # 1346, 'Check If N and Its Double Exist'
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 */

import java.util.*;

class Solution {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; ++i) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }

        if (m.containsKey(0) && m.get(0) >= 2) {
            return true;
        }
        for (int i = 0; i < arr.length; ++i) {
            int curr = arr[i];
            int dbl = curr * 2;

            if (curr != 0 && m.containsKey(dbl)) {
                return true;
            }
        }
        return false;
    }
}