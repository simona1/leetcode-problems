/**
 * LeetCode problem # 1720, 'Decode XORed Array'
 * https://leetcode.com/problems/decode-xored-array/
 */

/**
 * @param {number[]} encoded
 * @param {number} first
 * @return {number[]}
 */

const decode = (encoded, first, res = [first]) => {
  for (const x of encoded) {
    res.push(x ^ res[res.length - 1]);
  }
  return res;
};
