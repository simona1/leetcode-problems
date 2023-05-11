/**
 * LeetCode problem # 2629, 'Function Composition'
 * https://leetcode.com/problems/function-composition
 */

/**
 * @param {Function[]} functions
 * @return {Function}
 */
function compose(functions) {
  return function (a) {
    let res = a;
    for (let i = functions.length - 1; i >= 0; --i) {
      res = functions[i](res);
    }
    return res;
  };
}

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */
