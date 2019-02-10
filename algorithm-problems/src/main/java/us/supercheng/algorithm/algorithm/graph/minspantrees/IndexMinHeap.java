package us.supercheng.algorithm.algorithm.graph.minspantrees;

import us.supercheng.algorithm.common.helper.ArrayHelper;
import us.supercheng.algorithm.common.helper.PrintHelper;

public class IndexMinHeap<Item extends Comparable> {
    private Item[] data;
    private Integer [] indexes;
    private int size;
    private int capacity;

    public IndexMinHeap(int capacity) {
        this.capacity = capacity;
        this.data = (Item[]) new Comparable[this.capacity+1];
        this.indexes = new Integer[this.capacity + 1];
    }

    public IndexMinHeap(Item[] arr) {
        this.capacity = arr.length;
        this.data = (Item[]) new Comparable[this.capacity+1];
        this.indexes = new Integer[this.capacity + 1];

        for (int i=0;i<arr.length;i++) {
            this.data[i+1] = arr[i];
            this.indexes[i+1] = i+1;
        }

        for (int i=this.size/2;i>0;i--)
            this.shiftDown(i);
    }

    public void insert(int index, Item item) {
        if (this.size + 1 <= this.capacity) {
            this.data[++index] = item;
            this.indexes[++size] = index;
            this.shiftUp(this.size);
        }
    }

    public void shiftUp(int index) {
        int parent = this.getParent(index);
        if(parent > 0 && this.data[this.indexes[index]].compareTo(this.data[this.indexes[parent]]) < 0) {
            ArrayHelper.swap(this.indexes, index, parent);
            this.shiftUp(parent);
        }
    }

    public void shiftDown(int index) {
        while (this.getLeftChild(index) <= this.size) {
            int left = this.getLeftChild(index);
            if (left + 1 <= this.size && this.data[this.indexes[left+1]].compareTo(this.data[this.indexes[left]]) < 0)
                left++;

            if (this.data[this.indexes[left]].compareTo(this.data[this.indexes[index]]) < 0) {
                ArrayHelper.swap(this.indexes, left, index);
                index = left;
            } else
                return;
        }
    }

    public Item getMin() {
        if (this.isEmpty())
            return null;
        return this.data[this.indexes[1]];
    }

    public int getMinIndex() {
        if(this.isEmpty())
            return -1;
        return this.indexes[1]-1;
    }

    public Item popMin() {
        if (this.isEmpty())
            return null;
        Item ret = this.getMin();
        ArrayHelper.swap(this.indexes, 1, this.size--);
        this.shiftDown(1);
        return ret;
    }


    public int popMinIndex() {
        if (this.isEmpty())
            return -1;
        int ret = this.indexes[1] - 1;
        this.popMin();
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
        Integer[] temp = new Integer[this.indexes.length];
        for(int i=0;i<temp.length;i++)
            temp[i] = this.indexes[i];
        PrintHelper.echoLn("\r\nIndex:");
        ArrayHelper.echo(temp);
        PrintHelper.echoLn("Data:");
        ArrayHelper.echo(this.data);

//        PrintHelper.echoLn("Reverse Index:");
//        temp = new Integer[this.reverse.length];
//        for(int i=0;i<temp.length;i++)
//            temp[i] = this.reverse[i];
//        ArrayHelper.echo(temp);
//        PrintHelper.echoLn("");
    }

    boolean contain( int i ){
        if (++i<=this.size)
            return this.data[i] != null;
        return false;
    }

    public Item getItem( int i ){
        if (this.contain(i))
            return this.data[++i];
        return null;
    }

    public void change( int i , Item newItem ){
        this.data[++i] = newItem;
        for (int j=1;j<this.indexes.length;j++) {
            ArrayHelper.echo(indexes);
            PrintHelper.echoLn(">" + j);
            if (indexes[j] == i) {
                this.shiftDown(j);
                this.shiftUp(j);
                return;
            }
        }
    }

    public static void main(String[] args) {
        int N = 10;
        IndexMinHeap<Character> indexMaxHeap = new IndexMinHeap<>(N);
//        for( int i = 0 ; i < N ; i ++ )
//            indexMaxHeap.insert( i , (int)(Math.random()*N) );
        indexMaxHeap.insert(0, 'A');
        indexMaxHeap.insert(1, 'C');
        indexMaxHeap.insert(2, 'A');
        indexMaxHeap.insert(3, 'F');
        indexMaxHeap.insert(4, 'Z');
        indexMaxHeap.insert(5, 'Q');
        indexMaxHeap.insert(6, 'E');
        indexMaxHeap.insert(7, 'F');
        indexMaxHeap.insert(8, 'X');
        indexMaxHeap.insert(9, 'W');
        indexMaxHeap.echo();

        PrintHelper.echoLn("GetMin: " + indexMaxHeap.getMin());
        int maxIndex = indexMaxHeap.popMinIndex();
        PrintHelper.echoLn("PopMinIndex: " + maxIndex);
        PrintHelper.echoLn("PopMin: " + indexMaxHeap.getItem(maxIndex));
        indexMaxHeap.echo();

        for(int i=0;i<N-1;i++) {
            PrintHelper.echoLn("PopMin ---> " + indexMaxHeap.popMin() + " size: " + indexMaxHeap.size());
            indexMaxHeap.echo();
        }

        PrintHelper.echoLn(indexMaxHeap.getItem(0));
        indexMaxHeap.echo();
    }
}