
/**
 * LeetCode problem # 97, 'Interleaving String'
 * https://leetcode.com/problems/interleaving-string/
 */

import java.util.*;

class Solution {
    public boolean isInterleave(String a, String b, String c) {
        if (a.length() + b.length() != c.length()) {
            return false;
        }
        return isInterleaveImpl(a, b, c, 0, 0, new HashMap<>());
    }

    private boolean isInterleaveImpl(String a, String b, String c, int ai, int bi, Map<String, Boolean> cache) {
        String key = ai + " " + bi;
        Boolean val = cache.get(key);
        if (val != null) {
            return val;
        }
        if (a.length() == ai && b.length() == bi) {
            cache.put(key, true);
            return true;
        }
        int ci = ai + bi;
        if (ai < a.length() && a.charAt(ai) == c.charAt(ci) && isInterleaveImpl(a, b, c, ai + 1, bi, cache)) {
            cache.put(key, true);
            return true;
        }
        if (bi < b.length() && b.charAt(bi) == c.charAt(ci) && isInterleaveImpl(a, b, c, ai, bi + 1, cache)) {
            cache.put(key, true);
            return true;
        }
        cache.put(key, false);
        return false;

    }

}