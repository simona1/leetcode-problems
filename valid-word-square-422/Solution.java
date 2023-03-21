
/**
 * LeetCode problem # 422, 'Valid Word Square'
 * https://leetcode.com/problems/valid-word-square
 */

import java.util.*;

class Solution {
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); ++i) {
            String row = words.get(i);
            String col = readCol(words, i);
            if (!row.equals(col)) {
                return false;
            }
        }
        return true;
    }

    private String readCol(List<String> words, int index) {
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (index >= word.length()) {
                return sb.toString();
            }
            sb.append(word.charAt(index));
        }
        return sb.toString();
    }
}
