/**
 * LeetCode problem # 2622, 'Cache With Time Limit'
 * https://leetcode.com/problems/cache-with-time-limit
 */

const TimeLimitedCache = function () {
  this.cache = new Map();
};

/**
 * @param {number} key
 * @param {number} value
 * @param {number} time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function (key, value, duration) {
  const curr = Date.now();
  const hasUnexpiredValue =
    this.cache.has(key) && this.cache.get(key).expires > curr;
  this.cache.set(key, { value, expires: curr + duration });
  return hasUnexpiredValue;
};

/**
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function (key) {
  if (this.cache.has(key)) {
    const { value, expires } = this.cache.get(key);
    if (Date.now() < expires) {
      return value;
    }
    this.cache.delete(key);
  }
  return -1;
};

/**
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function () {
  let count = 0;
  const ts = Date.now();
  for (const [key, { expires }] of this.cache.entries()) {
    if (ts < expires) {
      ++count;
    } else {
      this.cache.delete(key);
    }
  }
  return count;
};

/**
 * Your TimeLimitedCache object will be instantiated and called as such:
 * const obj = new TimeLimitedCache()
 * obj.set(1, 42, 1000); // false
 * obj.get(1) // 42
 * obj.count() // 1
 */
