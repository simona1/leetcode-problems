/**
 * LeetCode problem # 2690, 'Infinite Method Object'
 * https://leetcode.com/problems/infinite-method-object/
 */

/**
 * @return {Object}
 */
var createInfiniteObject = function (...args) {
  return new Proxy(
    {},
    {
      get(target, prop) {
        return () => String(prop);
      },
    }
  );
};

/**
 * const obj = createInfiniteObject();
 * obj['abc123'](); // "abc123"
 */
