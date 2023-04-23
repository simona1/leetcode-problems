/**
 * LeetCode problem # 2651, 'Calculate Delayed Arrival Time'
 * https://leetcode.com/problems/calculate-delayed-arrival-time
 */

/**
 * @param {number} arrivalTime
 * @param {number} delayedTime
 * @return {number}
 */
function findDelayedArrivalTime(arrivalTime, delayedTime) {
  return (arrivalTime + delayedTime) % 24;
}
