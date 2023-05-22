/**
 * LeetCode problem # 2628, 'JSON Deep Equal'
 * https://leetcode.com/problems/json-deep-equal/
 */

/**
 * @param {any} o1
 * @param {any} o2
 * @return {boolean}
 */
var areDeeplyEqual = function (o1, o2) {
  if (o1 === o2) {
    return true;
  }

  if (
    typeof o1 !== "object" ||
    o1 == null ||
    typeof o2 !== "object" ||
    o2 == null
  ) {
    return false;
  }

  const isObj1Arr = Array.isArray(o1);
  const isObj2Arr = Array.isArray(o2);

  if (isObj1Arr !== isObj2Arr) {
    return false;
  }
  if (isObj1Arr && isObj2Arr) {
    return (
      o1.length === o2.length &&
      o1.every((elem, i) => areDeeplyEqual(elem, o2[i]))
    );
  }

  const obj1Keys = Object.keys(o1);
  const obj2Keys = Object.keys(o2);
  if (obj1Keys.length !== obj2Keys.length) {
    return false;
  }

  return obj1Keys.every((key, i) => {
    if (!obj2Keys.includes(key)) {
      return false;
    }
    return areDeeplyEqual(o1[key], o2[key]);
  });
};
