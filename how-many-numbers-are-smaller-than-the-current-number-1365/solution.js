/**
 * LeetCode problem # 1365, 'How Many Numbers Are Smaller Than the Current Number'
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */

/**
 * @param {number[]} nums
 * @return {number[]}
 */

/* brute force  approach */
function smallerNumbersThanCurrent(nums) {
  const n = nums.length;
  const res = [];
  for (let i = 0; i < n; ++i) {
    let count = 0;
    for (let j = 0; j < n; ++j) {
      if (i != j && nums[j] < nums[i]) {
        ++count;
      }
    }
    res.push(count);
  }
  return res;
}

/*  map approach */
function smallerNumbersThanCurrent(nums) {
  const sorted = [...nums].sort((a, b) => a - b);
  const map = new Map();
  sorted.forEach((num, i) => {
    if (!map.has(num)) {
      map.set(num, i);
    }
  });

  return nums.map((num) => map.get(num));
}
