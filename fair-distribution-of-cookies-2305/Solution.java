
/**
 * LeetCode problem # 2305, 'Fair Distribution of Cookies'
 * https://leetcode.com/problems/fair-distribution-of-cookies/
 */

class Solution {
    int res = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        int[] q = new int[k];
        dfs(cookies, q, 0);
        return res;
    }

    private void dfs(int[] cookies, int[] q, int index) {
        if (index == cookies.length) {
            int sum = 0;
            for (int i = 0; i < q.length; ++i) {
                sum = Math.max(sum, q[i]);
            }
            res = Math.min(res, sum);
            return;
        }

        for (int i = 0; i < q.length; ++i) {
            q[i] += cookies[index];
            if (q[i] < res) {
                dfs(cookies, q, index + 1);
            }
            q[i] -= cookies[index];
        }
    }
}