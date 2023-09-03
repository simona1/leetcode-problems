/**
 * LeetCode problem # 2631, 'Group By'
 * https://leetcode.com/problems/group-by/
 */

/**
 * @param {Function} fn
 * @return {Array}
 */
Array.prototype.groupBy = function (fn) {
  const groups = {};
  for (const elem of this) {
    const key = fn(elem);
    groups[key] ??= [];
    groups[key].push(elem);
  }
  return groups;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */
