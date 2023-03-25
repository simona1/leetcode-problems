
/**
 * LeetCode problem # 1773, 'Count Items Matching a Rule'
 * https://leetcode.com/problems/count-items-matching-a-rule
 */

import java.util.*;

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;

        for (List<String> item : items) {
            String t = item.get(0);
            String c = item.get(1);
            String n = item.get(2);
            if ((ruleKey.equals("type") && ruleValue.equals(t)) || (ruleKey.equals("color") && ruleValue.equals(c))
                    || (ruleKey.equals("name") && ruleValue.equals(n))) {
                ++res;
            }
        }
        return res;
    }
}
