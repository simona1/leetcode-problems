/**
 * LeetCode problem # 2114, 'Maximum Number of Words Found in Sentences'
 * https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
 */

class Solution {
    public int mostWordsFound(String[] sentences) {
        int res = 0;
        for (String sentence : sentences) {
            int count = 0;
            for (int i = 0; i < sentence.length(); ++i) {
                if (sentence.charAt(i) == ' ') {
                    ++count;
                }
            }
            res = Math.max(count + 1, res);
        }
        return res;

    }
}