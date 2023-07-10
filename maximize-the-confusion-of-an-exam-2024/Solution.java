
/**
 * LeetCode problem # 2024, 'Maximize the Confusion of an Exam'
 * https://leetcode.com/problems/maximize-the-confusion-of-an-exam/
 */

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int left = 0;
        int right = 0;

        int tCount = 0;
        int fCount = 0;
        int max = 0;

        while (right < n) {
            if (answerKey.charAt(right) == 'T') {
                ++tCount;
            } else {
                ++fCount;
            }
            if (tCount <= k || fCount <= k) {
                max = Math.max(max, right - left + 1);
            } else {
                if (answerKey.charAt(left) == 'T') {
                    --tCount;
                } else {
                    --fCount;
                }
                ++left;
            }
            ++right;
        }
        return max;
    }
}