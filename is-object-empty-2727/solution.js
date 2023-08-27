/**
 * LeetCode problem # 2727, 'Is Object Empty'
 * https://leetcode.com/problems/is-object-empty/
 */

/**
 * @param {Object | Array} obj
 * @return {boolean}
 */

//  O(n) because of Object.keys(obj)
function isEmpty1(obj) {
  if (Array.isArray(obj)) {
    return obj.length === 0;
  }
  if (typeof obj === "object") {
    return Object.keys(obj).length === 0;
  }
}

// constant time
function isEmpty(obj) {
  if (Array.isArray(obj)) {
    return obj.length === 0;
  }

  let keyCount = 0;
  for (let key in obj) {
    keyCount = (obj[key] ?? 0) + 1;
    if (keyCount > 0) {
      return false;
    }
  }
  return keyCount === 0;
}
