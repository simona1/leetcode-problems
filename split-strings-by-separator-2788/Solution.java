
/**
 * LeetCode problem # 2788, 'Split Strings by Separator'
 * https://leetcode.com/problems/split-strings-by-separator
 */

import java.util.*;

class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            String sep = "\\" + separator;
            String[] curr = word.split(sep);
            for (String c : curr) {
                if (c.length() > 0) {
                    res.add(c);
                } else {
                    continue;
                }
            }
        }
        return res;
    }
}
