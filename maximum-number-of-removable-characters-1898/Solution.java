
/**
 * LeetCode problem # 1898, 'Maximum Number of Removable Characters'
 * https://leetcode.com/problems/maximum-number-of-removable-characters
 */

import java.util.*;

class Solution {
    private boolean isSubsequence(String s, String p, Set<Integer> removed) {
        int sn = s.length();
        int pn = p.length();
        int si = 0;
        int pi = 0;

        while (si < sn && pi < pn) {
            if (removed.contains(si)) {
                ++si;
                continue;
            }

            if (s.charAt(si) == p.charAt(pi)) {
                ++si;
                ++pi;
            } else {
                ++si;
            }
        }
        return pi == pn;
    }

    private boolean canFormSubseq(String s, String p, int[] removable, int k) {
        Set<Integer> removed = new HashSet<>();
        for (int i = 0; i < k; ++i) {
            removed.add(removable[i]);
        }
        return isSubsequence(s, p, removed);
    }

    public int maximumRemovals(String s, String p, int[] removable) {
        int diff = s.length() - p.length();
        int n = removable.length;

        int low = 0;
        int high = Math.min(diff, n) + 1;

        while (low + 1 != high) {
            int mid = low + (high - low) / 2;
            if (canFormSubseq(s, p, removable, mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
