/**
 * LeetCode problem # 1399, 'Count Largest Group'
 * https://leetcode.com/problems/count-largest-group/
 */

/**
 * @param {number} n
 * @return {number}
 */
function countLargestGroup(n) {
  const sum = (x) => (x == 0 ? 0 : (x % 10) + sum(Math.floor(x / 10)));

  const map = new Map();

  for (let i = 1; i <= n; ++i) {
    let k = sum(i);
    map.set(k, 1 + (map.get(k) ?? 0));
  }

  let max = Math.max(...map.values());
  return [...map.entries()].filter((a) => a[1] == max).length;
}
