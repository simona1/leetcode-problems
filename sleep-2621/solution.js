/**
 * LeetCode problem # 2621, 'Sleep'
 * https://leetcode.com/problems/sleep/
 */

/**
 * @param {number} millis
 */
async function sleep(millis) {
  await new Promise((res) => setTimeout(res, millis));
}

/**
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */
