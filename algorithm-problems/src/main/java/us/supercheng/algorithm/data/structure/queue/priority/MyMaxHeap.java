package us.supercheng.algorithm.data.structure.queue.priority;

import us.supercheng.algorithm.common.helper.PrintHelper;
import us.supercheng.algorithm.data.structure.array.MyArray;

public class MyMaxHeap<E extends Comparable<E>> {

    private MyArray<E> array;

    public MyMaxHeap() {
        this.array = new MyArray<>();
    }

    public MyMaxHeap(int capacity) {
        if(capacity < 0)
            throw new IllegalArgumentException("Invalid Capacity: " + capacity);
        this.array = new MyArray<>(capacity);
    }

    public MyMaxHeap(E[] arr) {
        this();
        for(E each : arr)
            this.add(each);
    }

    public int size() {
        return this.array.getSize();
    }

    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    public void add(E e) {
        this.array.addLast(e);
        this.siftUp(this.size() - 1);
    }

    // Max or Min
    public E getNext() {
        return this.isEmpty() ? null : this.array.get(0);
    }

    public E extractNext() {
        if(this.isEmpty())
            throw new IllegalArgumentException("Empty Priority Queue");
        E ret = this.getNext();
        this.array.set(0, this.array.remove(this.size() - 1));
        this.array.set(this.size() - 1, null);
        this.siftDown(0);
        return ret;
    }

    public E replace(E e) {
        E ret = this.getNext();
        this.array.set(0, e);
        this.siftDown(0);
        return ret;
    }


    private void siftDown(int index) {
        E left = this.array.get(this.getLeftChildIndex(index));
        E right = this.array.get(this.getRightChildIndex(index));
        E curr = this.array.get(index);

        while(curr.compareTo(left) > 0 || curr.compareTo(right) > 0 && index < this.size()) {
            if(left.compareTo(right) < 0) {
                this.array.set(index, right);
                this.array.set(this.getRightChildIndex(index), curr);
                index = this.getRightChildIndex(index);
            } else {
                this.array.set(index, left);
                this.array.set(this.getLeftChildIndex(index), curr);
                index = this.getLeftChildIndex(index);
            }
        }
    }

    private void siftUp(int index) {
        while(index >= 0 && this.array.get(index).compareTo(this.array.get(this.getParentIndex(index))) > 0) {
            E swap = this.array.get(index);
            this.array.set(index, this.array.get(this.getParentIndex(index)));
            this.array.set(this.getParentIndex(index), swap);
            index = this.getParentIndex(index);
        }
    }


    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return (parentIndex + 1) * 2 - 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return (parentIndex + 1) * 2;
    }

    public void print() {
        for(int i=0;i<this.size();i++)
            PrintHelper.echo(this.array.get(i) + " ");
        PrintHelper.echoLn("");
    }
}