/**
 * LeetCode problem # 56, 'Merge Intervals'
 * https://leetcode.com/problems/merge-intervals
 */

/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
function merge(intervals) {
  intervals.sort((a, b) => a[0] - b[0]);
  const res = [];

  for (const iv of intervals) {
    const prev = res.at(-1);

    if (!res.length || prev[1] < iv[0]) {
      res.push(iv);
    } else {
      prev[1] = Math.max(prev[1], iv[1]);
    }
  }
  return res;
}
