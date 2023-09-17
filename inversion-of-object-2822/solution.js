/**
 * LeetCode problem # 2822, 'Inversion of Object'
 * https://leetcode.com/problems/inversion-of-object
 */

/**
 * @param {Object} obj
 * @return {Object}
 */
function invertObject(obj) {
  const res = {};

  for (const key in obj) {
    const val = obj[key];

    if (!res.hasOwnProperty(val)) {
      res[val] = key;
    } else {
      if (typeof res[val] === "string") {
        res[val] = [res[val]];
      }
      res[val].push(key);
    }
  }
  return res;
}
