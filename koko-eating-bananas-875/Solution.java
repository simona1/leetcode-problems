/*
 * LeetCode problem # 875, 'Koko Eating Bananas'
 * https://leetcode.com/problems/koko-eating-bananas
 */

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int lo = 0;
        int hi = 0;

        for (int pile : piles) {
            hi = Math.max(hi, pile);
        }

        while (lo + 1 != hi) {
            int mid = (lo + hi) / 2;
            long hoursNeeded = 0;

            for (int pile : piles) {
                hoursNeeded += (pile + mid - 1) / mid;
            }

            if (hoursNeeded <= h) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return hi;
    }
}
