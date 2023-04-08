/**
 * LeetCode problem # 1656, 'Design an Ordered Stream'
 * https://leetcode.com/problems/design-an-ordered-stream
 */

import java.util.*;

class OrderedStream {

    private String[] arr;
    private int ptr;

    public OrderedStream(int n) {
        this.arr = new String[n + 1];
        this.ptr = 1;
    }
    
    public List<String> insert(int idKey, String value) {
        arr[idKey] = value;
        List<String> list = new LinkedList<>();
        while (this.ptr < arr.length && arr[ptr] != null) {
            list.add(arr[ptr++]);
        }
        return list;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */

