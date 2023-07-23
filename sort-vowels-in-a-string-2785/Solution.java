
/**
 * LeetCode problem # 2785, 'Sort Vowels in a String'
 * https://leetcode.com/problems/sort-vowels-in-a-string/
 */

import java.util.*;

class Solution {
    public String sortVowels(String s) {
        char[] chars = s.toCharArray();

        List<Character> vowels = new ArrayList<>();

        for (char c : chars) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }
        Collections.sort(vowels);
        // System.out.println(vowels);
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (char c : chars) {
            if (!isVowel(c)) {
                sb.append(c);
            } else {
                sb.append(vowels.get(index));
                ++index;
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        Set<Character> set = new HashSet<>();
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < vowels.length(); ++i) {
            set.add(vowels.charAt(i));
        }
        return set.contains(c);
    }
}