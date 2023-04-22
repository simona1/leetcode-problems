/**
 * LeetCode problem # 1122, 'Relative Sort Array'
 * https://leetcode.com/problems/relative-sort-array
 */

/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
function relativeSortArray(arr1, arr2) {
  const map = new Map();
  const set = new Set();

  for (let i = 0; i < arr1.length; ++i) {
    map.set(arr1[i], (map.get(arr1[i]) ?? 0) + 1);
    set.add(arr1[i]);
  }

  const res = [];
  for (const num of arr2) {
    const rep = map.get(num);
    for (let i = 0; i < rep; ++i) {
      res.push(num);
    }
    set.delete(num);
  }
  const rest = [];
  for (const num of set) {
    const rep = map.get(num);
    for (let i = 0; i < rep; ++i) {
      rest.push(num);
    }
  }
  rest.sort((a, b) => a - b);

  return [...res, ...rest];
}
