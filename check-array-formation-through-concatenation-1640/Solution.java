/**
 * LeetCode problem # 1640, 'Check Array Formation Through Concatenation'
 * https://leetcode.com/problems/check-array-formation-through-concatenation
 */

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length;
        int index = 0;

        while (index < n) {
            int curr = -1;
            for (int j = 0; j < pieces.length; ++j) {
                if (pieces[j][0] == arr[index]) {
                    curr = j;
                    break;
                }
            }
            if (curr == -1) {
                return false;
            }

            int[] piece = pieces[curr];
            for (int num : piece) {
                if (num != arr[index]) {
                    return false;
                }
                ++index;
            }
        }
        return true;
    }
}