/**
 * LeetCode problem # 1725, 'Number Of Rectangles That Can Form The Largest
 * Square'
 * https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/
 */

class Solution {
    public int countGoodRectangles(int[][] rectangles) {

        int largest = 0;
        int[] sides = new int[rectangles.length];
        int i = 0;

        for (int[] rect : rectangles) {
            int side = Math.min(rect[0], rect[1]);
            sides[i] = side;
            ++i;
            largest = Math.max(largest, side);
        }

        int res = 0;
        for (int side : sides) {
            if (side == largest) {
                ++res;
            }
        }
        return res;
    }
}
