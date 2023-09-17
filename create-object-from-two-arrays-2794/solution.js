/**
 * LeetCode problem # 2794, 'Create Object from Two Arrays'
 * https://leetcode.com/problems/create-object-from-two-arrays
 */

/**
 * @param {Array} keysArr
 * @param {Array} valuesArr
 * @return {Object}
 */
const createObject = function (keysArr, valuesArr) {
  const keys = keysArr.map((key) => String(key));
  const res = {};
  for (let i = 0; i < keys.length; ++i) {
    if (res.hasOwnProperty(keys[i])) {
      continue;
    }
    res[keys[i]] = valuesArr[i];
  }
  return res;
};
