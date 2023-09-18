/**
 * LeetCode problem # 1282, 'Group the People Given the Group Size They Belong To'
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 */

/**
 * @param {number[]} groupSizes
 * @return {number[][]}
 */
function groupThePeople(groupSizes) {
  const res = [];
  const map = new Map();

  for (let i = 0; i < groupSizes.length; ++i) {
    const curr = groupSizes[i];
    const group = map.get(curr) ?? [];
    group.push(i);
    map.set(curr, group);
    if (group.length === curr) {
      res.push(group);
      map.delete(curr);
    }
  }
  return res;
}

/*



[3,3,3,3,3,1,3]
Output: [[5],[0,1,2],[3,4,6]]


*/
