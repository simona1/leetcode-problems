/**
 * LeetCode problem # 2610, 'Convert an Array Into a 2D Array With Conditions'
 * https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
 */

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
function findMatrix(nums) {
  const map = new Map();

  for (const n of nums) {
    map.set(n, (map.get(n) ?? 0) + 1);
  }

  const res = [];

  while (true) {
    const row = [...map.keys()].filter((x) => map.get(x) > 0);
    if (row.length === 0) {
      break;
    }
    res.push(row);
    for (const x of row) {
      map.set(x, map.get(x) - 1);
    }
  }

  return res;
}
