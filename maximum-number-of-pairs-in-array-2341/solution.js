/**
 * LeetCode problem # 2341, 'Maximum Number of Pairs in Array'
 * https://leetcode.com/problems/maximum-number-of-pairs-in-array
 */

/**
 * @param {number[]} nums
 * @return {number[]}
 */
function numberOfPairs(nums) {
  const fr = new Map();

  for (const num of nums) {
    fr.set(num, (fr.get(num) ?? 0) + 1);
  }

  let pairs = 0;
  for (const [key, val] of fr) {
    if (val % 2 === 0) {
      pairs += val / 2;
      fr.delete(key);
    } else {
      const pairsToRemove = Math.floor(val / 2);
      pairs += pairsToRemove;
      fr.set(key, val % 2);
    }
  }
  return [pairs, fr.size];
}
