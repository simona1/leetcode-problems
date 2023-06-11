
/**
 * LeetCode problem # 2728, 'Count Houses in a Circular Street'
 * https://leetcode.com/problems/count-houses-in-a-circular-street
 */

/**
 * Definition for a street.
 * 
 * class Street { public Street(int[] doors); public void openDoor(); public
 * void closeDoor(); public boolean isDoorOpen(); public void moveRight();
 * public void moveLeft(); }
 */

class Solution {
    public int houseCount(Street street, int k) {
        for (int i = 0; i < k; ++i) {
            if (street.isDoorOpen()) {
                street.closeDoor();
            }
            street.moveRight();
        }

        street.openDoor();
        street.moveRight();

        int res = 1;
        while (!street.isDoorOpen()) {
            ++res;
            street.moveRight();
        }

        return res;
    }
}
