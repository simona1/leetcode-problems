/**
 * LeetCode problem # 2644, 'Find the Maximum Divisibility Score'
 * https://leetcode.com/problems/find-the-maximum-divisibility-score/
 */

/**
 * @param {number[]} nums
 * @param {number[]} divisors
 * @return {number}
 */
var maxDivScore = function (nums, divisors) {
  return maxByTuple(divisors, (div) => {
    let count = 0;
    for (const num of nums) {
      if (num % div === 0) {
        ++count;
      }
    }
    return [count, -div];
  });
};

function compareTuples(a, b) {
  if (a.length !== b.length) {
    throw new Error();
  }
  for (let i = 0; i < a.length; ++i) {
    if (a[i] < b[i]) {
      return -1;
    }
    if (a[i] > b[i]) {
      return 1;
    }
  }
  return 0;
}

function maxByTuple(arr, fn) {
  let best = null;
  let bestScore = null;

  for (const elem of arr) {
    const score = fn(elem);

    if (bestScore == null || compareTuples(score, bestScore) > 0) {
      best = elem;
      bestScore = score;
    }
  }
  return best;
}

function maxBy(arr, fn) {
  let best = null;
  let bestScore = null;

  for (const elem of arr) {
    const score = fn(elem);
    if (bestScore == null || score > bestScore) {
      best = elem;
      bestScore = score;
    }
  }
  return best;
}

function minBy(arr, fn) {
  let best = null;
  let bestScore = null;

  for (const elem of arr) {
    const score = fn(elem);
    if (bestScore == null || score < bestScore) {
      best = elem;
      bestScore = score;
    }
  }
  return best;
}
