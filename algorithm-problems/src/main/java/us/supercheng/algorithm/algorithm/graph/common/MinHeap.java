package us.supercheng.algorithm.algorithm.graph.common;

import us.supercheng.algorithm.common.helper.ArrayHelper;
import us.supercheng.algorithm.common.helper.PrintHelper;

public class MinHeap<Item extends Comparable> {
    private Item[] data;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.data = (Item[]) new Comparable[this.capacity+1];
    }

    public MinHeap(Item[] arr) {
        this.capacity = arr.length;
        this.data = (Item[]) new Comparable[this.capacity+1];

        for (int i=0;i<arr.length;i++)
            this.data[i+1] = arr[i];

        for (int i=this.size/2;i>0;i--)
            this.shiftDown(i);
    }

    public void insert(Item item) {
        if (this.size + 1 <= this.capacity) {
            this.data[++size] = item;
            this.shiftUp(this.size);
        }
    }

    public void shiftUp(int index) {
        int parent = this.getParent(index);
        if (parent > 0 && this.data[index].compareTo(this.data[parent]) < 0) {
            ArrayHelper.swap(this.data, index, parent);
            this.shiftUp(parent);
        }
    }

    public void shiftDown(int index) {
        while (this.getLeftChild(index) <= this.size) {
            int left = this.getLeftChild(index);
            if (left + 1 <= this.size && this.data[left+1].compareTo(this.data[left]) < 0)
                left++;

            if (this.data[left].compareTo(this.data[index]) < 0) {
                ArrayHelper.swap(this.data, left, index);
                index = left;
            } else
                return;
        }
    }

    public Item getMin() {
        if (this.isEmpty())
            return null;
        return this.data[1];
    }

    public Item popMin() {
        if (this.isEmpty())
            return null;
        Item ret = this.getMin();
        ArrayHelper.swap(this.data, 1, this.size--);
        this.shiftDown(1);
        return ret;
    }

    private int getLeftChild(int index) {
        return index*2;
    }

    private int getRightChild(int index) {
        return index*2+1;
    }

    private int getParent(int index) {
        return index/2;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void echo() {
        ArrayHelper.echo(this.data);
    }

    public static void main(String[] args) {
        int N = 10000;
        int M = 10000;
        //Integer[] num = SortTestHelper.generateRandomArray(N, M, -M);
        MinHeap<Integer> minHeap = new MinHeap<>(M);

        for( int i = 0 ; i < N ; i ++ )
            minHeap.insert( new Integer((int)(Math.random() * M)) );


        Integer[] arr = new Integer[N];
        for ( int i = 0 ; i < N ; i ++ ) {
            arr[i] = minHeap.popMin();
            PrintHelper.echo(arr[i] + ", ");
        }
        PrintHelper.echoLn("");

        for( int i = 1 ; i < N ; i ++ ) {
            if (arr[i-1] > arr[i]) {
                PrintHelper.echoLn("Wrong Not Sorted at " + (i-1));
                ArrayHelper.echo(arr);
            }
        }
    }
}