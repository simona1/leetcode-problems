/**
 * LeetCode problem # 2646, 'Minimize the Total Price of the Trips'
 * https://leetcode.com/problems/minimize-the-total-price-of-the-trips
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
