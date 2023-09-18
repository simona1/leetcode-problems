/**
 * LeetCode problem # 1359, 'Count All Valid Pickup and Delivery Options'
 * https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options
 */

const MOD = Math.pow(10, 9) + 7;
let cache;

const countOrders = function (n) {
  cache = new Array(n + 1).fill(0).map(() => new Array(n + 1).fill(0));

  const getWays = (p, d) => {
    if (p === 0 && d === 0) {
      return 1;
    }

    if (p < 0 || d < 0 || d < p) {
      return 0;
    }

    if (cache[p][d]) {
      return cache[p][d];
    }

    let res = 0;

    // Pick up options
    res += p * getWays(p - 1, d);
    res %= MOD;

    // Delivery
    res += (d - p) * getWays(p, d - 1);
    res %= MOD;

    return (cache[p][d] = res);
  };

  return getWays(n, n);
};
