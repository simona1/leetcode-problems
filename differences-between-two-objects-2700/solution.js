/**
 * LeetCode problem # 2700, 'Differences Between Two Objects'
 * https://leetcode.com/problems/differences-between-two-objects/
 */

/**
 * @param {object} obj1
 * @param {object} obj2
 * @return {object}
 */
function objDiff(obj1, obj2) {
  const res = {};

  for (const key in obj1) {
    if (!(key in obj2)) {
      continue;
    }
    const val1 = obj1[key];
    const val2 = obj2[key];

    if (typeof val1 !== "object" || typeof val2 !== "object") {
      if (val1 !== val2) {
        res[key] = [val1, val2];
      }
    } else if (Array.isArray(val1) !== Array.isArray(val2)) {
      res[key] = [val1, val2];
    } else {
      const tmp = objDiff(val1, val2);
      const length = Object.keys(tmp).length;
      if (length == 0) {
        continue;
      }
      res[key] = tmp;
    }
  }
  return res;
}
