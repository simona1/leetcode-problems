
/**
 * LeetCode problem # 1065, 'Index Pairs of a String'
 * https://leetcode.com/problems/index-pairs-of-a-string
 */

import java.util.*;

class Solution {
    public int[][] indexPairs(String text, String[] words) {

        List<int[]> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        for (int i = 0; i < text.length(); ++i) {
            for (int j = i; j < text.length(); ++j) {
                if (set.contains(text.substring(i, j + 1))) {
                    list.add(new int[] { i, j });
                }
            }
        }

        int[][] res = new int[list.size()][];
        int index = 0;
        for (int[] l : list) {
            res[index] = l;
            ++index;
        }
        return res;
    }
}
