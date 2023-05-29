
/**
 * LeetCode problem # 2525, 'Categorize Box According to Criteria'
 * https://leetcode.com/problems/categorize-box-according-to-criteria
 */

class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        long volume = 1L * length * width * height;
        int dim = 10000;
        int vol = (int) Math.pow(10, 9);
        boolean isBulky = volume >= vol || length >= dim || width >= dim || height >= dim;
        boolean isHeavy = mass >= 100;

        if (isBulky && isHeavy) {
            return "Both";
        }
        if (!isBulky && !isHeavy) {
            return "Neither";
        }
        if (isBulky) {
            return "Bulky";
        }
        if (isHeavy) {
            return "Heavy";
        }
        return null;
    }
}