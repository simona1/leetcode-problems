
/**
 * LeetCode problem # 1125, 'Smallest Sufficient Team'
 * https://leetcode.com/problems/smallest-sufficient-team/
 */

import java.util.*;

class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = people.size();
        int m = req_skills.length;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            map.put(req_skills[i], i);
        }

        int personMask[] = new int[n];
        for (int i = 0; i < n; ++i) {
            for (String skill : people.get(i)) {
                personMask[i] |= 1 << map.get(skill);
            }
        }

        long dp[] = new long[1 << m];
        Arrays.fill(dp, (1L << n) - 1);
        dp[0] = 0;

        for (int skillsMask = 1; skillsMask < (1 << m); ++skillsMask) {
            for (int i = 0; i < n; ++i) {
                int smallerSkillsMask = skillsMask & ~personMask[i];
                if (smallerSkillsMask != skillsMask) {
                    long peopleMask = dp[smallerSkillsMask] | (1L << i);
                    if (Long.bitCount(peopleMask) < Long.bitCount(dp[skillsMask])) {
                        dp[skillsMask] = peopleMask;
                    }
                }
            }
        }
        long res = dp[(1 << m) - 1];
        int ans[] = new int[Long.bitCount(res)];
        int ptr = 0;
        for (int i = 0; i < n; i++) {
            if (((res >> i) & 1) == 1) {
                ans[ptr++] = i;
            }
        }
        return ans;
    }
}