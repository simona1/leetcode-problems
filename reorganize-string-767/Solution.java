
/**
 * LeetCode problem # 767, 'Reorganize String'
 * https://leetcode.com/problems/reorganize-string/
 */

import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            counts[ch - 'a']++;
        }

        Comparator<int[]> comp = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        };

        int lim = (s.length() + 1) / 2;

        PriorityQueue<int[]> pq = new PriorityQueue<>(comp);
        for (int i = 0; i < counts.length; ++i) {
            int count = counts[i];
            if (count > lim) {
                return "";
            }
            if (count > 0) {
                pq.add(new int[] { count, 'a' + i });
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != (char) curr[1]) {
                sb.append((char) curr[1]);
                if (curr[0] > 1) {
                    curr[0] -= 1;
                    pq.add(curr);
                }
            } else {
                int[] p = pq.remove();
                sb.append((char) p[1]);
                if (p[0] > 1) {
                    p[0] -= 1;
                    pq.add(p);
                }
                pq.add(curr);
            }
        }
        return sb.toString();
    }
}