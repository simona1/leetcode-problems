
/**
 * LeetCode problem # 1337, 'The K Weakest Rows in a Matrix'
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 */

import java.util.*;

class Row {
    int strength;
    int index;

    public Row(int s, int i) {
        this.strength = s;
        this.index = i;
    }
}

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        int index = 0;

        PriorityQueue<Row> pq = new PriorityQueue<>(new Comparator<Row>() {
            public int compare(Row i, Row j) {
                if (i.strength == j.strength) {
                    return j.index - i.index;
                }
                return j.strength - i.strength;
            }
        });

        for (int[] row : mat) {
            int count = 0;
            for (int r : row) {
                count = (r == 1) ? (count + 1) : count;
            }
            Row curr = new Row(count, index);
            ++index;
            pq.add(curr);
        }
        while (pq.size() > k) {
            pq.remove();
        }
        Stack<Integer> st = new Stack<>();

        while (!pq.isEmpty()) {
            st.push(pq.remove().index);
        }
        int[] res = new int[k];
        int i = 0;
        while (!st.isEmpty()) {
            res[i] = st.pop();
            ++i;
        }
        return res;
    }
}
