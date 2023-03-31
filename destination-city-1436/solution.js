/**
 * LeetCode problem # 1436, 'Destination City'
 * https://leetcode.com/problems/destination-city/
 */

/**
 * @param {string[][]} paths
 * @return {string}
 */
function destCity(paths) {
  const set = new Set(paths.flatMap((p) => p));

  for (const p of paths) {
    set.delete(p[0]);
  }

  return [...set][0];
}
