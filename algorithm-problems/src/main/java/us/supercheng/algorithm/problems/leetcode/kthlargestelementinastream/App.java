package us.supercheng.algorithm.problems.leetcode.kthlargestelementinastream;

import java.util.ArrayList;
import java.util.Collections;

public class App {

    private int kth;
    private ArrayList<Integer> list;

    public App(int k, int[] nums) {
        this.kth = k - 1;
        this.list = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            this.add(nums[i]);
    }

    public int add(int val) {
        int index = Collections.binarySearch(this.list, val);
        if(index > -1)
            this.list.add(index, val);
        else
            this.list.add(-1*(index+1), val);
        int count = this.list.size() - 1 - this.kth;
        if(count >= 0 && count <= this.list.size()-1)
            return this.list.get(count);
        else
            return this.list.get(0);
    }
}