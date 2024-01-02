/**
 * LeetCode problem # 15, '3Sum'
 * https://leetcode.com/problems/3sum
 */

function threeSum(nums: number[]): number[][] {
    nums.sort((a, b) => a - b);
    const res: number[][] = [];

    for (let i = 0; i < nums.length; ++i) {
        if (i > 0 && nums[i] === nums[i - 1]) {
            continue;
        }
        let lo = i + 1;
        let hi = nums.length - 1;

        while (lo < hi) {
            if (lo > i + 1 && nums[lo] === nums[lo - 1]) {
                ++lo;
                continue;
            }
            if (hi < nums.length - 1 && nums[hi] === nums[hi + 1]) {
                --hi;
                continue;
            }

            const sum = nums[i] + nums[lo] + nums[hi];

            if (sum > 0) {
                --hi;
                continue;
            }
            if (sum < 0) {
                ++lo;
                continue;
            }

            res.push([nums[i], nums[lo], nums[hi]]);
            ++lo;
            --hi;
        }
    }
    return res;
}
