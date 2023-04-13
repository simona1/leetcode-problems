/**
 * LeetCode problem # 2631, 'Group By'
 * https://leetcode.com/problems/group-by/
 */

/**
 * @param {Function} fn
 * @return {Array}
 */
Array.prototype.groupBy = function (fn) {
  const map = new Map();

  for (const elem of this) {
    const key = fn(elem);
    let group = map.get(key);
    if (group == null) {
      group = [];
      map.set(key, group);
    }
    group.push(elem);
  }
  return Object.fromEntries(map.entries());
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */
