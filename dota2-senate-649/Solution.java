
/**
 * LeetCode problem # 649, 'Dota2 Senate'
 * https://leetcode.com/problems/dota2-senate/
 */

class Solution {
    public void banNext(String senate, boolean[] banned, char toBan, int index) {
        int ptr = index;
        while (true) {
            if (senate.charAt(ptr) == toBan && !banned[ptr]) {
                banned[ptr] = true;
                break;
            }
            ptr = (ptr + 1) % senate.length();
        }
    }

    public String predictPartyVictory(String senate) {
        int n = senate.length();
        boolean[] banned = new boolean[n];

        int rc = 0;
        int dc = 0;
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                ++rc;
            } else {
                ++dc;
            }
        }

        int nextMove = 0;
        while (rc > 0 && dc > 0) {
            if (!banned[nextMove]) {
                if (senate.charAt(nextMove) == 'D') {
                    banNext(senate, banned, 'R', (nextMove + 1) % n);
                    --rc;
                } else {
                    banNext(senate, banned, 'D', (nextMove + 1) % n);
                    --dc;
                }
            }
            nextMove = (nextMove + 1) % n;
        }
        return rc == 0 ? "Dire" : "Radiant";
    }
}
