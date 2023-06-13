
/**
 * LeetCode problem # 2379, 'Minimum Recolors to Get K Consecutive Black Blocks'
 * https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
 */

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int start = 0;
        int end = 0;
        int res = Integer.MAX_VALUE;
        int b = 0;
        int w = 0;
        while (end < blocks.length()) {
            if (blocks.charAt(end) == 'B') {
                b++;
            } else {
                w++;
            }
            end++;
            if (end - start == k) {
                res = Math.min(res, w);
                if (blocks.charAt(start) == 'B') {
                    b--;
                } else {
                    w--;
                }
                start++;
            }

        }
        return res;
    }
}
