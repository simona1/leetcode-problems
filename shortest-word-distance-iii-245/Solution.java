
/**
 * LeetCode problem # 245, 'Shortest Word Distance III'
 * https://leetcode.com/problems/shortest-word-distance-iii/
 */

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int index = -1;
        int min = wordsDict.length;
        int n = wordsDict.length;

        for (int i = 0; i < n; ++i) {
            if (wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) {
                if (index != -1 && (word1.equals(word2) || !wordsDict[index].equals(wordsDict[i]))) {
                    min = Math.min(i - index, min);
                }
                index = i;
            }
        }
        return min;
    }
}