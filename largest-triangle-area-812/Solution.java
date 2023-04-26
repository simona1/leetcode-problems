/**
 * LeetCode problem # 812, 'Largest Triangle Area'
 * https://leetcode.com/problems/largest-triangle-area/
 */

class Solution {
    public double largestTriangleArea(int[][] points) {
        double area = 0.0;
        int n = points.length;
        for (int i = 0; i < n; ++i) {
            int[] a = points[i];
            for (int j = i + 1; j < n; ++j) {
                int[] b = points[j];
                for (int k = j + 1; k < n; ++k) {
                    int[] c = points[k];
                    area = Math.max(area, computeArea(a, b, c));
                }
            }
        }
        return area;
    }

    // Ax(By - Cy) + Bx(Cy - Ay) + Cx(Ay - By) divided by 2
    private double computeArea(int[] a, int[] b, int[] c) {
        return Math.abs(a[0] * (b[1] - c[1]) + b[0] * (c[1] - a[1]) + c[0] * (a[1] - b[1])) / 2.0;
    }
}
