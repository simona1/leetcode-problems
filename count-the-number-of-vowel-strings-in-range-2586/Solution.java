
/**
 * LeetCode problem # 2586, 'Count the Number of Vowel Strings in Range'
 * https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range
 */

import java.util.*;

class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;

        for (int i = left; i <= right && i < words.length; ++i) {
            String curr = words[i];
            if (isVowel(curr.charAt(0)) && isVowel(curr.charAt(curr.length() - 1))) {
                ++res;
            }
        }
        return res;
    }

    private boolean isVowel(char c) {
        Set<Character> set = new HashSet<>();

        String vowels = "aeiou";

        for (int i = 0; i < vowels.length(); ++i) {
            set.add(vowels.charAt(i));
        }
        return set.contains(c);
    }
}
