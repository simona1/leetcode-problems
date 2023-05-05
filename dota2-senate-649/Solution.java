
/**
 * LeetCode problem # 649, 'Dota2 Senate'
 * https://leetcode.com/problems/dota2-senate/
 */

import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();

        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                r.add(i);
            } else {
                d.add(i);
            }
        }
        while (!r.isEmpty() && !d.isEmpty()) {
            int rs = r.remove();
            int ds = d.remove();
            if (rs < ds) {
                r.add(rs + n);
            } else {
                d.add(ds + n);
            }
        }
        return r.isEmpty() ? "Dire" : "Radiant";
    }
}
