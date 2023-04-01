/**
 * LeetCode problem # 2363, 'Merge Similar Items'
 * https://leetcode.com/problems/merge-similar-items/
 */

/**
 * @param {number[][]} items1
 * @param {number[][]} items2
 * @return {number[][]}
 */
function mergeSimilarItems(items1, items2) {
  const map = {};
  for (const [a, b] of items1) {
    map[a] = (map[a] ?? 0) + b;
  }
  for (const [a, b] of items2) {
    map[a] = (map[a] ?? 0) + b;
  }
  return Object.keys(map).map((key) => [key, map[key]]);
}
