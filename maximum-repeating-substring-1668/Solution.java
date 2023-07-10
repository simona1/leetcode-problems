
/**
 * LeetCode problem # 1668, 'Maximum Repeating Substring'
 * https://leetcode.com/problems/maximum-repeating-substring
 */

class Solution {
    public int maxRepeating(String sequence, String word) {
        int lo = -1;
        int hi = sequence.length() / word.length() + 1;

        while (lo + 1 != hi) {
            int mid = (lo + hi + 1) / 2;
            if (canMake(sequence, word, mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public boolean canMake(String sequence, String word, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; ++i) {
            sb.append(word);
        }
        int i = sequence.indexOf(sb.toString());
        return i >= 0;
    }
}
