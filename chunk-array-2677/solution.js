/**
 * LeetCode problem # 2677, 'Chunk Array'
 * https://leetcode.com/problems/chunk-array
 */

/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array[]}
 */
function chunk(arr, size) {
  const res = [];
  while (arr.length) {
    res.push(arr.splice(0, size));
  }
  return res;
}
