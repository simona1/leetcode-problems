
/**
 * LeetCode problem # 2405, 'Optimal Partition of String'
 * https://leetcode.com/problems/optimal-partition-of-string/
 */

import java.util.*;

class Solution {
    public int partitionString(String s) {
        int index = 0;
        int res = 0;

        Set<Character> set = new HashSet<>();
        while (index < s.length()) {
            if (set.contains(s.charAt(index))) {
                ++res;
                set.clear();
            }
            set.add(s.charAt(index));
            ++index;
        }
        return res + 1;
    }
}
