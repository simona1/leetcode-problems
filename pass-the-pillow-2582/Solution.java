/*
 * LeetCode problem # 2582, 'Pass the Pillow'
 * https://leetcode.com/problems/pass-the-pillow
 */

import java.util.*;

class Solution {
    public int passThePillow(int n, int time) {

        int dir = 1;
        int curr = 1;

        List<Integer> list = new ArrayList<>();

        while (time >= list.size()) {
            list.add(curr);
            curr += dir;

            if (curr == n || curr == 1) {
                dir = -dir;
            }
        }
        return list.get(time);
    }
}
