/**
 * LeetCode problem # 888, 'Fair Candy Swap'
 * https://leetcode.com/problems/fair-candy-swap/
 */

/**
 * @param {number[]} aliceSizes
 * @param {number[]} bobSizes
 * @return {number[]}
 */
function fairCandySwap(aliceSizes, bobSizes) {
  const sumA = aliceSizes.reduce((a, c) => a + c);
  const sumB = bobSizes.reduce((a, c) => a + c);

  const diff = (sumB - sumA) / 2;
  const set = new Set();
  for (const box of bobSizes) {
    set.add(box);
  }

  const res = [];
  for (const box of aliceSizes) {
    if (set.has(box + diff)) {
      res.push(box, box + diff);
      break;
    }
  }
  return res;
}
