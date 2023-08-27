/**
 * LeetCode problem # 646, 'Maximum Length of Pair Chain'
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 */

/**
 * @param {number[][]} pairs
 * @return {number}
 */
function findLongestChain(pairs) {
  const sortedPairs = pairs.sort((a, b) => a[1] - b[1]);

  let curr = -Infinity;
  let n = 0;

  for (const [a, b] of sortedPairs) {
    if (curr < a) {
      ++n;
      curr = b;
    }
  }
  return n;
}
