
/**
 * LeetCode problem # 1030, 'Matrix Cells in Distance Order'
 * https://leetcode.com/problems/matrix-cells-in-distance-order/
 */

import java.util.*;

class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
                (a, b) -> (Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter))
                        - (Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter)));

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                pq.add(new int[] { i, j });
            }
        }

        int res[][] = new int[rows * cols][2];

        for (int i = 0; i < res.length; ++i) {
            res[i] = pq.remove();
        }

        return res;
    }
}
