
/**
 * LeetCode problem # 288, 'Unique Word Abbreviation'
 * https://leetcode.com/problems/unique-word-abbreviation
 */

import java.util.*;

class ValidWordAbbr {
    private Map<String, Set<String>> map;

    public ValidWordAbbr(String[] dictionary) {
        this.map = new HashMap<>();
        for (String word : dictionary) {
            String abbr = getAbbreviation(word);
            map.computeIfAbsent(abbr, k -> new HashSet<>()).add(word);
        }
    }

    private String getAbbreviation(String word) {
        int n = word.length();
        if (n <= 2) {
            return word;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        int len = n - 2;
        if (len > 0) {
            sb.append(len);
        }
        sb.append(word.charAt(n - 1));

        return sb.toString();
    }

    public boolean isUnique(String word) {
        String abbr = getAbbreviation(word);
        Set<String> set = map.get(abbr);

        return set == null || (set.size() == 1 && set.contains(word));
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary); boolean param_1 =
 * obj.isUnique(word);
 */
