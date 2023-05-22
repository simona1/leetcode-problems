/**
 * LeetCode problem # 2633, 'Convert Object to JSON String'
 * https://leetcode.com/problems/convert-object-to-json-string
 */

/**
 * @param {any} object
 * @return {string}
 */
const jsonStringify = (obj) => {
  if (Array.isArray(obj)) {
    return "[" + obj.map((elem) => jsonStringify(elem)).join(",") + "]";
  }
  if (obj && typeof obj == "object") {
    return (
      "{" +
      Object.keys(obj)
        .map((key) => `"${key}":` + jsonStringify(obj[key]))
        .join(",") +
      "}"
    );
  }
  return typeof obj == "string" ? `"${obj}"` : `${obj}`;
};
