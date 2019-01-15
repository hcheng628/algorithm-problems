package us.supercheng.algorithm.algorithm.heap;

import us.supercheng.algorithm.common.helper.ArrayHelper;
import us.supercheng.algorithm.common.helper.PrintHelper;

public class MaxHeap<T extends Comparable> {

    private int size;
    private int capacity;
    private T [] data;

    public MaxHeap(int capacity) {
        if(capacity < 1)
            throw new IllegalArgumentException("Capacity needs to be greater than or equal to zero.");
        this.capacity = capacity;
        this.data = (T []) new Comparable [this.capacity + 1];
    }

    public MaxHeap(Comparable[] arr) {
        this.capacity = arr.length;
        this.data = (T []) new Comparable [this.capacity + 1];
        for(int i=1;i<this.data.length;i++)
            this.data[i] = (T) arr[i-1];
        this.size = this.capacity;

        for(int i=this.size/2;i>=1;i--)
            shiftDown(i);
    }

    private void shiftUp(int index) {
        while(index > 1 && this.data[index/2].compareTo(this.data[index]) < 0) {
            int parent = index/2;
            ArrayHelper.swap(this.data, index, parent);
            index = parent;
        }
    }

    private void shiftDown(int index) {
        while(index * 2 <= this.size) {
            int child = index * 2;
            if(child + 1 <= this.size && this.data[child+1].compareTo(this.data[child]) > 0) {
                child++;
            }

            if(this.data[index].compareTo(this.data[child]) >= 0)
                break;
            ArrayHelper.swap(this.data, index, child);
            index = child;
        }
    }

    public void insert(T t) {
        if(this.size + 1 > this.capacity)
            throw new RuntimeException("No more storage capacity");
        this.data[++this.size] = t;
        this.shiftUp(this.size);

        ArrayHelper.echo(this.data);
        PrintHelper.echoLn("");
    }

    public T popMax() {
        if(this.isEmpty())
            throw new RuntimeException("Empty Max Heap");
        T ret = this.data[1];
        ArrayHelper.swap(this.data, 1, this.size--);
        this.shiftDown(1);
        return ret;
    }

    public T getMax() {
        if(this.isEmpty())
            throw new RuntimeException("Empty Max Heap");
        return this.data[1];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void echo() {
        for(int i=1;i<this.data.length;i++)
            PrintHelper.echo(this.data[i] + " ");
    }

    public static void main(String[] args) {
        int SIZE = 100;
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(SIZE);
        int N = SIZE;
        int M = 1000;
        for( int i = 0 ; i < N ; i ++ )
            maxHeap.insert( new Integer((int)(Math.random() * M)) );

        Integer[] arr = new Integer[N];
        for( int i=N-1 ; i>=0 ;i -- ){
            arr[i] = maxHeap.popMax();
            //PrintHelper.echo(arr[i] + " ");
        }
        PrintHelper.echoLn("");

        PrintHelper.echoLn("Is Sorted: " + ArrayHelper.isSorted(arr));

        for( int i = 1 ; i < N ; i ++ )
            assert arr[i-1] >= arr[i];
        Integer [] nums = {2,1,3,4,7,9,6,5,8};
        MaxHeap<Integer> maxHeap1 = new MaxHeap<Integer>(nums);
        maxHeap1.echo();

    }
}