
/**
 * LeetCode problem # 2418, 'Sort the People'
 * https://leetcode.com/problems/sort-the-people
 */

import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Person[] people = new Person[n];
        for (int i = 0; i < n; ++i) {
            people[i] = new Person(names[i], heights[i]);
        }
        Arrays.sort(people, Comparator.comparingInt(p -> -p.height));
        for (int i = 0; i < n; ++i) {
            names[i] = people[i].name;
        }
        return names;
    }
}

class Person {
    int height;
    String name;

    public Person(String n, int h) {
        this.name = n;
        this.height = h;
    }

    public String toString() {
        return this.name + ", " + this.height;
    }
}