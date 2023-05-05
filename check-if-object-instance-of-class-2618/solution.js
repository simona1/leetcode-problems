/**
 * LeetCode problem # 2618, 'Check if Object Instance of Class'
 * https://leetcode.com/problems/check-if-object-instance-of-class/
 */

/**
 * @param {any} object
 * @param {any} classFunction
 * @return {boolean}
 */
function checkIfInstanceOf(obj, classFunction) {
  while (obj != null) {
    if (obj.constructor == classFunction) {
      return true;
    }
    obj = Object.getPrototypeOf(obj);
  }
  return false;
}

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */
