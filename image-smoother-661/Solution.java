/**
 * LeetCode problem # 661, 'Image Smoother'
 * https://leetcode.com/problems/image-smoother
 */

class Solution {
    static int[][] DIRS = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 0 }, { 0, 1 }, { 1, -1 },
            { 1, 0 }, { 1, 1 } };

    public int[][] imageSmoother(int[][] img) {
        int row = img.length;
        int col = img[0].length;

        if (img == null || row == 0) {
            return img;
        }

        int[][] res = new int[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                int count = 0;
                int sum = 0;

                for (int[] dir : DIRS) {
                    int nr = i + dir[0];
                    int nc = j + dir[1];
                    if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
                        continue;
                    }
                    ++count;
                    sum += img[nr][nc];
                }

                int grayScaled = sum / count;
                res[i][j] = grayScaled;
            }
        }
        return res;
    }
}
