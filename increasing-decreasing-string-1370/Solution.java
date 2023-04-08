
/**
 * LeetCode problem # 1370, 'Increasing Decreasing String'
 * https://leetcode.com/problems/increasing-decreasing-string
 */

import java.util.*;

class Solution {
    public String sortString(String s) {
        StringBuilder sb = new StringBuilder();
        TreeMap<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < s.length(); ++i) {
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        int index = 0;
        while (true) {
            StringBuilder curr = new StringBuilder();

            for (Character c : map.keySet()) {
                if (map.get(c) != 0) {
                    curr.append(c);
                    map.put(c, map.getOrDefault(c, 0) - 1);
                }
            }

            if (curr.length() == 0) {
                break;
            }

            if (index++ % 2 == 0) {
                sb.append(curr);
            } else {
                sb.append(curr.reverse());
            }
        }
        return sb.toString();
    }
}