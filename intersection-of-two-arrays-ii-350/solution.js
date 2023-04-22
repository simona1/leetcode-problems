/**
 * LeetCode problem # 350, 'Intersection of Two Arrays II'
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
function intersect(nums1, nums2) {
  if (nums1.length > nums2.length) {
    intersect(nums2, nums1);
  }

  const n1 = {};
  for (let i = 0; i < nums1.length; ++i) {
    n1[nums1[i]] = 1 + (n1[nums1[i]] || 0);
  }

  const n2 = {};
  for (let i = 0; i < nums2.length; ++i) {
    n2[nums2[i]] = 1 + (n2[nums2[i]] || 0);
  }

  const res = [];
  for (key in n1) {
    if (!n2[key]) {
      continue;
    } else {
      const val = Math.min(n1[key], n2[key]);
      for (let j = 0; j < val; ++j) {
        res.push(key);
      }
    }
  }
  return res;
}
