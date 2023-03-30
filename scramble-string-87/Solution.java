
/**
 * LeetCode problem # 87, 'Scramble String'
 * https://leetcode.com/problems/scramble-string
 */

import java.util.*;

class Solution {
    Map<String, Boolean> map = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        return isScrambleImpl(s1, s2);
    }

    boolean isScrambleImpl(String s1, String s2) {

        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append("-");
        sb.append(s2);

        String key = sb.toString();

        Boolean hasScramble = map.get(key);
        if (hasScramble != null) {
            return hasScramble;
        }

        if (s1.equals(s2)) {
            map.put(key, true);
            return true;
        }
        int n = s1.length();

        for (int i = 1; i < n; ++i) {

            if (isScrambleImpl(s1.substring(0, i), s2.substring(0, i))
                    && isScrambleImpl(s1.substring(i), s2.substring(i))
                    || isScrambleImpl(s1.substring(0, i), s2.substring(n - i))
                            && isScrambleImpl(s1.substring(i), s2.substring(0, n - i))) {
                map.put(key, true);
                return true;
            }
        }

        map.put(key, false);
        return false;
    }
}
