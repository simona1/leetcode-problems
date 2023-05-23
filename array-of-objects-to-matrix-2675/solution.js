/**
 * LeetCode problem # 2675, 'Array of Objects to Matrix'
 * https://leetcode.com/problems/array-of-objects-to-matrix
 */

/**
 * @param {Array} arr
 * @return {Matrix}
 */
function jsonToMatrix(arr) {
  const res = [];
  const flattened = arr.map((elem) => flattenObject(elem));

  for (const elem of flattened) {
    for (const key of Object.keys(elem)) {
      if (!res.includes(key)) {
        res.push(key);
      }
    }
  }
  res.sort();
  const result = [res];
  for (const elem of flattened) {
    const curr = [];
    for (const key of res) {
      if (key in elem) {
        curr.push(elem[key]);
      } else {
        curr.push("");
      }
    }
    result.push(curr);
  }
  return result;
}

function flattenObject(obj, p, res = {}) {
  for (const key in obj) {
    let prop = p ? p + "." + key : key;
    if (typeof obj[key] === "object" && obj[key] != null) {
      flattenObject(obj[key], prop, res);
    } else {
      res[prop] = obj[key];
    }
  }
  return res;
}
