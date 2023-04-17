
/**
 * LeetCode problem # 2643, 'Row With Maximum Ones'
 * https://leetcode.com/problems/row-with-maximum-ones/
 */

class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {

        int[] res = new int[2];

        for (int j = 0; j < mat.length; ++j) {
            int[] row = mat[j];
            int count = 0;
            for (int i = 0; i < row.length; ++i) {
                if (row[i] == 1) {
                    ++count;
                }
            }

            if (res[1] < count) {
                res[0] = j;
                res[1] = count;
            }
        }
        return res;
    }
}
