/**
 * LeetCode problem # 1877, 'Minimize Maximum Pair Sum in Array'
 * https://leetcode.com/problems/minimize-maximum-pair-sum-in-array
 */

function minPairSum(nums: number[]): number {
    nums.sort((a, b) => a - b);

    let i = 0;
    let j = nums.length - 1;
    let res = -Infinity;
    while (i < j) {
        res = Math.max(res, nums[i] + nums[j]);
        ++i;
        --j;
    }
    return res;
}