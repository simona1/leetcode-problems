/**
 * LeetCode problem # 2610, 'Convert an Array Into a 2D Array With Conditions'
 * https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
 */

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
function findMatrix(nums) {
  const freq = new Map();

  for (const num of nums) {
    freq.set(num, (freq.get(num) ?? 0) + 1);
  }
  const values = [...freq.values()].sort((a, b) => a - b);
  if (values.every((val) => val == 1)) {
    return [nums];
  }
  if (nums.length == 1) {
    return [[nums]];
  }
  const rows = values[values.length - 1];

  const res = Array(rows)
    .fill(null)
    .map(() => []);

  for (const key of freq.keys()) {
    const n = freq.get(key);
    for (let i = 0; i < freq.get(key); ++i) {
      if (res[i] != null) {
        res[i].push(key);
      }
    }
  }
  return res;
}
