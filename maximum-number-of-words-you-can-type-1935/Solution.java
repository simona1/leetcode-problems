
/**
 * LeetCode problem # 1935, 'Maximum Number of Words You Can Type'
 * https://leetcode.com/problems/maximum-number-of-words-you-can-type/
 */

import java.util.*;

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> broken = new HashSet<>();

        for (int i = 0; i < brokenLetters.length(); ++i) {
            broken.add(brokenLetters.charAt(i));
        }

        int count = 0;
        String[] words = text.split(" ");
        for (String word : words) {
            boolean canType = true;
            for (int i = 0; i < word.length(); ++i) {
                if (broken.contains(word.charAt(i))) {
                    canType = false;
                    break;
                }
            }
            if (canType) {
                ++count;
            }
        }
        return count;
    }
}