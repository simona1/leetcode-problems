
/**
 * LeetCode problem # 17, 'Letter Combinations of a Phone Number'
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

import java.util.*;

class Solution {
    static String[] letters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.length() == 0) {
            return res;
        }

        if (digits.length() == 1) {
            for (char c : letters[digits.charAt(0) - '0'].toCharArray()) {
                res.add(c + "");
            }
            return res;
        }

        for (char c : letters[digits.charAt(0) - '0'].toCharArray()) {
            for (String s : letterCombinations(digits.substring(1))) {
                res.add(c + s);
            }
        }
        return res;
    }
}
