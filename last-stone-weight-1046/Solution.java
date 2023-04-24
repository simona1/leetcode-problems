/**
 * LeetCode problem # 1046, 'Last Stone Weight'
 * https://leetcode.com/problems/last-stone-weight
 */

import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int stone : stones) {
            pq.add(stone);
        }
        
        while (pq.size() > 1) {
            int first = pq.remove();
            int second = pq.remove();
            if (first != second) {
                pq.add(first - second);
            }
        }
        if (pq.isEmpty()) {
            return 0;
        }
        return pq.remove();
    }
}
