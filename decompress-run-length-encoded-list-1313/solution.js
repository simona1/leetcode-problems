/**
 * LeetCode problem # 1313, 'Decompress Run-Length Encoded List'
 * https://leetcode.com/problems/decompress-run-length-encoded-list
 */

/**
 * @param {number[]} nums
 * @return {number[]}
 */
function decompressRLElist(nums) {
  const res = [];
  for (let i = 0; i < nums.length; i += 2) {
    const freq = nums[i];
    const num = nums[i + 1];
    for (let j = 0; j < freq; ++j) {
      res.push(num);
    }
  }
  return res;
}
