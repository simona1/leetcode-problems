/*
 * LeetCode problem # 502, 'IPO'
 * https://leetcode.com/problems/ipo
 *
 */

import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> capitalPq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> profitsPq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

        for (int i = 0; i < profits.length; ++i) {
            capitalPq.add(new int[] { capital[i], profits[i] });
        }

        for (int i = 0; i < k; ++i) {
            while (!capitalPq.isEmpty() && capitalPq.peek()[0] <= w) {
                profitsPq.add(capitalPq.remove());

            }
            if (profitsPq.isEmpty()) {
                break;
            }

            w += profitsPq.remove()[1];
        }

        return w;
    }
}
