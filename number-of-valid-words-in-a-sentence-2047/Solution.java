
/**
 * LeetCode problem # 2047, 'Number of Valid Words in a Sentence'
 * https://leetcode.com/problems/number-of-valid-words-in-a-sentence/
 */

import java.util.*;

class Solution {
    public int countValidWords(String sentence) {
        int res = 0;

        // Split the sentence
        String[] words = sentence.split(" ");
        int n = words.length;

        for (int i = 0; i < n; ++i) {
            String curr = words[i];
            int flag = 0;

            int m = curr.length();
            for (int j = 0; j < m; ++j) {
                if (Character.isDigit(curr.charAt(j))) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                continue;
            }

            // Check all char are in lowerCase
            if (!curr.equals(curr.toLowerCase())) {
                continue;
            }

            Map<Character, Integer> map = new HashMap<>();

            for (int k = 0; k < m; ++k) {
                map.put(curr.charAt(k), map.getOrDefault(curr.charAt(k), 0) + 1);
            }

            // Check hyphen count
            int hyph = 0;
            Integer val = map.get('-');
            if (val != null) {
                hyph = val;
            }

            if (hyph > 1) {
                continue;
            }

            // Check punctuation counts
            int punct = 0;

            Integer excl = map.get('!');
            Integer dot = map.get('.');
            Integer comma = map.get(',');

            if (excl != null) {
                punct += excl;
            }
            if (dot != null) {
                punct += dot;
            }
            if (comma != null) {
                punct += comma;
            }
            if (punct > 1) {
                continue;
            }

            // Check hyphen is between lowercase letters
            if (val != null) {
                if (curr.startsWith("-") || curr.endsWith("-")) {
                    continue;
                }
                int pos = curr.indexOf("-");
                char before = curr.charAt(pos - 1);
                char after = curr.charAt(pos + 1);

                if (!Character.isLowerCase(before) || !Character.isLowerCase(after)) {
                    continue;
                }
            }

            // Check punctuation is last
            if (excl != null) {
                if (!curr.endsWith("!")) {
                    continue;
                }
            }

            if (dot != null) {
                if (!curr.endsWith(".")) {
                    continue;
                }
            }

            if (comma != null) {
                if (!curr.endsWith(",")) {
                    continue;
                }
            }

            // Check if a token is a space
            if (map.size() == 0) {
                continue;
            }
            ++res;
        }
        return res;
    }
}