
/**
 * LeetCode problem # 705, 'Design HashSet'
 * https://leetcode.com/problems/design-hashset
 */

import java.util.*;

class MyHashSet {
    private Bucket[] arr;
    private int keyRange;

    public MyHashSet() {
        this.keyRange = 769;
        this.arr = new Bucket[this.keyRange];
        for (int i = 0; i < this.keyRange; ++i) {
            this.arr[i] = new Bucket();
        }
    }

    protected int _hash(int key) {
        return (key % this.keyRange);
    }

    public void add(int key) {
        int bucketIndex = this._hash(key);
        this.arr[bucketIndex].insert(key);
    }

    public void remove(int key) {
        int bucketIndex = this._hash(key);
        this.arr[bucketIndex].delete(key);
    }

    public boolean contains(int key) {
        int bucketIndex = this._hash(key);
        return this.arr[bucketIndex].exists(key);
    }
}

class Bucket {
    private LinkedList<Integer> container;

    public Bucket() {
        container = new LinkedList<Integer>();
    }

    public void insert(Integer key) {
        int index = this.container.indexOf(key);
        if (index == -1) {
            this.container.addFirst(key);
        }
    }

    public void delete(Integer key) {
        this.container.remove(key);
    }

    public boolean exists(Integer key) {
        int index = this.container.indexOf(key);
        return (index != -1);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */