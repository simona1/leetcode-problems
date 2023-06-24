
/**
 * LeetCode problem # 2744, 'Find Maximum Number of String Pairs'
 * https://leetcode.com/problems/find-maximum-number-of-string-pairs
 */

class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int n = words.length;

        int res = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i < j && words[i].equals(reverse(words[j]))) {
                    ++res;
                }
            }
        }
        return res;
    }

    private String reverse(String word) {
        int i = 0;
        int j = word.length() - 1;
        char[] arr = word.toCharArray();

        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            ++i;
            --j;
        }
        return String.valueOf(arr);
    }
}