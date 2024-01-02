/**
 * LeetCode problem # 2610, 'Convert an Array Into a 2D Array With Conditions'
 * https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
 */

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
function findMatrix(nums: number[]): number[][] {
    const map = new Map();

    for (const num of nums) {
        map.set(num, (map.get(num) ?? 0) + 1);
    }

    const res: number[][] = [];

    while (true) {
        const row = [...map.keys()].filter(elem => map.get(elem) > 0);
        if (!row.length) {
            break;
        }
        res.push(row);

        for (const r of row) {
            map.set(r, map.get(r) - 1);
        }
    }
    return res;
}
 


