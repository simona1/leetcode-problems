
/**
 * LeetCode problem # 808, 'Soup Servings'
 * https://leetcode.com/problems/soup-servings/
 */

class Solution {
    double[][] cache;

    public double soupServings(int n) {
        if (n >= 4800) {
            return 1.0;
        }
        cache = new double[n + 1][n + 1];
        return solve(n, n);
    }

    private double solve(int a, int b) {

        if (a <= 0 && b <= 0) {
            return 0.5;
        }

        if (a <= 0) {
            return 1.0;
        }

        if (b <= 0) {
            return 0;
        }

        if (cache[a][b] > 0) {
            return cache[a][b];
        }

        return cache[a][b] = 0.25
                * (solve(a - 100, b) + solve(a - 75, b - 25) + solve(a - 50, b - 50) + solve(a - 25, b - 75));
    }
}