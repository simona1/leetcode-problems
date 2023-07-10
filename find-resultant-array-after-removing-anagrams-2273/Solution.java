
/**
 * LeetCode problem # 2273, 'Find Resultant Array After Removing Anagrams'
 * https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
 */

import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();

        Stack<String> st = new Stack<>();
        st.push(words[0]);

        for (int i = 1; i < words.length; ++i) {
            if (!isAnagram(words[i], st.peek())) {
                st.push(words[i]);
            }
        }
        for (String word : st) {
            res.add(word);
        }

        return res;
    }

    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        char[] c = a.toCharArray();
        char[] d = b.toCharArray();

        Arrays.sort(c);
        Arrays.sort(d);
        return new String(c).equals(new String(d));
    }
}