/**
 * LeetCode problem # 2775, 'Undefined to Null'
 * https://leetcode.com/problems/undefined-to-null
 */

/**
 * @param {object} obj
 * @return {object}
 */
function undefinedToNull(obj) {
  for (const key in obj) {
    const val = obj[key];
    if (val === undefined) {
      obj[key] = null;
    } else if (typeof val === "object" || Array.isArray(val)) {
      undefinedToNull(val);
    }
  }
  return obj;
}

/**
 * undefinedToNull({"a": undefined, "b": 3}) // {"a": null, "b": 3}
 * undefinedToNull([undefined, undefined]) // [null, null]
 */
