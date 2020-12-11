package us.supercheng.algorithm.problems.leetcode.designcircularqueue;

import java.util.Arrays;

class MyCircularQueue {

    int [] arr;
    int capacity;
    int size;
    int first;
    int last;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.arr = new int [k];
        this.capacity = k;
        this.size = 0;
        this.first = 0;
        this.last = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (this.size + 1 > this.capacity)
            return false;

        if (!this.isEmpty())
            last = (last + 1) % this.capacity;

        this.size++;
        this.arr[last] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (this.isEmpty())
            return false;

        this.size--;
        if (!this.isEmpty())
            first = (first + 1) % this.capacity;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return this.isEmpty() ? -1 : this.arr[this.first];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return this.isEmpty() ? -1 : this.arr[this.last];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return this.size == this.capacity;
    }

    private void debug(String s) {
        this.echo(s + Arrays.toString(this.arr));
        this.echo("First -> " + this.first + " Last: " + this.last + " Size: " + this.size);
        this.echo("");
    }

    private void echo(Object o) {
        System.out.println(o);
    }
}