/**
 * LeetCode problem # 605, 'Can Place Flowers'
 * https://leetcode.com/problems/can-place-flowers/
 */

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; ++i) {
            if (flowerbed[i] == 0) {
                boolean left = i == 0 || flowerbed[i - 1] == 0;
                boolean right = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
                if (left && right) {
                    flowerbed[i] = 1;
                    ++count;
                }
            }
        }
        return count >= n;
    }
}
