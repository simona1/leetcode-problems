
/**
 * LeetCode problem # 2711, 'Difference of Number of Distinct Values on Diagonals'
 * https://leetcode.com/problems/difference-of-number-of-distinct-values-on-diagonals/
 */

import java.util.*;

class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[][] res = new int[r][c];

        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                // left up
                Set<Integer> left = new HashSet<>();
                int ni = i - 1;
                int nj = j - 1;
                while (ni >= 0 && nj >= 0) {
                    left.add(grid[ni][nj]);
                    --ni;
                    --nj;
                }

                Set<Integer> right = new HashSet<>();
                ni = i + 1;
                nj = j + 1;
                while (ni < r && nj < c) {
                    right.add(grid[ni][nj]);
                    ++ni;
                    ++nj;
                }
                res[i][j] = Math.abs(left.size() - right.size());
            }
        }
        return res;
    }
}
