/**
 * LeetCode problem # 1791, 'Find Center of Star Graph'
 * https://leetcode.com/problems/find-center-of-star-graph/
 */

/**
 * @param {number[][]} edges
 * @return {number}
 */
function findCenter(edges) {
  const map = new Map();

  for (const [a, b] of edges) {
    const va = (map.get(a) ?? 0) + 1;
    const vb = (map.get(b) ?? 0) + 1;
    map.set(a, va);
    map.set(b, vb);
  }

  let res = null;
  for (const [key, value] of map) {
    if (value == edges.length) {
      res = key;
      break;
    }
  }
  return res;
}
