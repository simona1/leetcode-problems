/**
 * LeetCode problem # 1184, 'Distance Between Bus Stops'
 * https://leetcode.com/problems/distance-between-bus-stops/
 */
/**
 * @param {number[]} distance
 * @param {number} start
 * @param {number} destination
 * @return {number}
 */

const distanceBetweenBusStops = (distance, start, destination) => {
  let clockwise = 0;
  let total = 0;

  if (start > destination) {
    [start, destination] = [destination, start];
  }
  for (let i = 0; i < distance.length; ++i) {
    total += distance[i];

    if (i >= start && i < destination) {
      clockwise += distance[i];
    }
  }
  return Math.min(clockwise, total - clockwise);
};
