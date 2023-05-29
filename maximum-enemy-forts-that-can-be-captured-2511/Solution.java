
/**
 * LeetCode problem # 2511, 'Maximum Enemy Forts That Can Be Captured'
 * https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured
 */

class Solution {
    public int captureForts(int[] forts) {
        return Math.max(fromLeft(forts), fromRight(forts));
    }

    private int fromLeft(int[] forts) {
        int res = 0;
        int n = forts.length;

        for (int i = 0; i < n; ++i) {
            if (forts[i] == 1) {
                for (int j = i + 1; j < n; ++j) {
                    if (forts[j] == 1) {
                        break;
                    }
                    if (forts[j] == -1) {
                        res = Math.max(res, j - i - 1);
                        break;
                    }
                }
            }
        }
        return res;
    }

    private int fromRight(int[] forts) {
        int res = 0;
        int n = forts.length;

        for (int i = n - 1; i >= 0; --i) {
            if (forts[i] == 1) {
                for (int j = i - 1; j >= 0; --j) {
                    if (forts[j] == 1) {
                        break;
                    }
                    if (forts[j] == -1) {
                        res = Math.max(res, i - j - 1);
                        break;
                    }
                }
            }
        }
        return res;
    }
}