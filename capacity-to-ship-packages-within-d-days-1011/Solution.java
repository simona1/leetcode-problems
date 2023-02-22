/*
 * LeetCode problem # 1011, 'Capacity To Ship Packages Within D Days'
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 */
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int totalLoad = 0;
        int maxLoad = 0;

        for (int w : weights) {
            totalLoad += w;
            maxLoad = Math.max(maxLoad, w);
        }

        int low = maxLoad;
        int high = totalLoad;

        while (low < high) {
            int mid = (low + high) / 2;
            if (isPossibleToShip(mid, weights, days)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isPossibleToShip(int capacity, int[] weights, int days) {
        int daysNeeded = 1;
        int curr = 0;

        for (int weight : weights) {
            curr += weight;
            if (curr > capacity) {
                ++daysNeeded;
                curr = weight;
            }
        }
        return daysNeeded <= days;
    }
}
