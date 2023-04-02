/**
 * LeetCode problem # 2611, 'Mice and Cheese'
 * https://leetcode.com/problems/mice-and-cheese/
 */

/**
 * @param {number[]} reward1
 * @param {number[]} reward2
 * @param {number} k
 * @return {number}
 */
function miceAndCheese(reward1, reward2, k) {
  const deltas = [];

  for (let i = 0; i < reward1.length; ++i) {
    deltas.push(reward1[i] - reward2[i]);
  }
  deltas.sort((a, b) => b - a);

  const sums2 = reward2.reduce((acc, cur) => acc + cur, 0);

  let res = 0;
  for (let i = 0; i < k; ++i) {
    res += deltas[i];
  }
  return sums2 + res;
}
