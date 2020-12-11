package us.supercheng.algorithm.problems.leetcode.designhashset;

import java.util.Arrays;

public class App2 {

    private int [] arr;
    /** Initialize your data structure here. */
    public App2() {
        this.arr = new int [10001];
        Arrays.fill(this.arr, -1);
    }

    public void add(int key) {
        if(!this.contains(key)) {
            for(int i=0;i<this.arr.length;i++)
                if(this.arr[i] == -1) {
                    this.arr[i] = key;
                    return;
                }
        }
    }

    public void remove(int key) {
        if(this.contains(key)) {
            for(int i=0;i<this.arr.length;i++) {
                if(this.arr[i] == key) {
                    this.arr[i] = -1;
                    return;
                }
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        for(int each : this.arr)
            if(each == key)
                return true;
        return false;
    }
}