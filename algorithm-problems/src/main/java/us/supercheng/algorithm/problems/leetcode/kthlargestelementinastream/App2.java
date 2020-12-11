package us.supercheng.algorithm.problems.leetcode.kthlargestelementinastream;

import java.util.PriorityQueue;

public class App2 {

    PriorityQueue<Integer> heap;
    int kTh;

    public App2(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        this.kTh = k;
        for(int num : nums)
            this.add(num);
    }

    public int add(int val) {
        this.heap.add(val);
        if(this.heap.size() > this.kTh)
            this.heap.poll();
        return this.heap.peek();
    }
}
