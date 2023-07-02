
/**
 * LeetCode problem # 1601, 'Maximum Number of Achievable Transfer Requests'
 * https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/
 */

class Solution {
    int res = 0;

    public void maxRequest(int[][] requests, int[] indegree, int n, int index, int count) {
        if (index == requests.length) {
            for (int i = 0; i < n; ++i) {
                if (indegree[i] != 0) {
                    return;
                }
            }

            res = Math.max(res, count);
            return;
        }

        indegree[requests[index][0]]--;
        indegree[requests[index][1]]++;

        maxRequest(requests, indegree, n, index + 1, count + 1);
        indegree[requests[index][0]]++;
        indegree[requests[index][1]]--;

        maxRequest(requests, indegree, n, index + 1, count);
    }

    public int maximumRequests(int n, int[][] requests) {
        int[] indegree = new int[n];
        maxRequest(requests, indegree, n, 0, 0);

        return res;
    }
}
