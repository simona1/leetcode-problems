/**
 * LeetCode problem # 2103, 'Rings and Rods'
 * https://leetcode.com/problems/rings-and-rods
 */

/**
 * @param {string} rings
 * @return {number}
 */
function countPoints(rings) {
  const map = {};

  for (let i = 1; i < rings.length; ++i) {
    let key = rings[i];
    let value = rings[i - 1];
    if (!map[key]) {
      map[key] = [];
    }
    map[key].push(value);
  }
  return Object.keys(map).filter((key) => containsAllThree(map[key])).length;
}

function containsAllThree(arr) {
  return arr.includes("B") && arr.includes("G") && arr.includes("R");
}
