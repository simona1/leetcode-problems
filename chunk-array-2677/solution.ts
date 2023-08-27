/**
 * LeetCode problem # 2677, 'Chunk Array'
 * https://leetcode.com/problems/chunk-array
 */

/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array[]}
 */
function chunk1(arr: any[], size: number): any[][] {
    const res: any[][] = [];
    
    for (let index = 0; index < arr.length; index += size) {
        res.push(slice(arr, index, index + size));   
    }
    return res;
};

function slice(arr: any[], start: number, end?: number): any[] {
    const res: any[] = [];
    
    const actualEnd = end == null ? arr.length : Math.min(end, arr.length);
    
    for (let i = start; i < actualEnd; ++i) {
        res.push(arr[i]);
    }

    return res;
}