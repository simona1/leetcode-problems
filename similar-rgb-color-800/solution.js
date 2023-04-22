/**
 * LeetCode problem # 800, 'Similar RGB Color'
 * https://leetcode.com/problems/similar-rgb-color/
 */

/**
 * @param {string} color
 * @return {string}
 */

function similarRGB(color) {
  const arr = [
    0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, 0x88, 0x99, 0xaa, 0xbb,
    0xcc, 0xdd, 0xee, 0xff,
  ];

  const rgb = [
    parseInt(color.slice(1, 3), 16),
    parseInt(color.slice(3, 5), 16),
    parseInt(color.slice(5, 7), 16),
  ];

  const res = [0, 0, 0];
  const diff = [-Infinity, -Infinity, -Infinity];

  arr.forEach((num) => {
    rgb.forEach((elem, i) => {
      const d = -Math.pow(num - elem, 2);
      if (d > diff[i]) {
        res[i] = Number(num).toString(16).padStart(2, "0");
        diff[i] = d;
      }
    });
  });
  return "#" + res.join("");
}
