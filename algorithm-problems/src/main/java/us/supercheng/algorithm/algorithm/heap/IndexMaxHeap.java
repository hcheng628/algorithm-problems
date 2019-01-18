package us.supercheng.algorithm.algorithm.heap;

import us.supercheng.algorithm.common.helper.ArrayHelper;
import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Arrays;

public class IndexMaxHeap<Item extends Comparable> {
    private int size;
    private int capacity;
    private Item[] data;
    private int [] indexes;

    public IndexMaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.data = (Item[]) new Comparable[this.capacity+1];
        this.indexes = new int [capacity+1];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Item getMax() {
        if(this.isEmpty())
            throw new RuntimeException("Empty " + this.getClass().getSimpleName());
        return this.data[this.indexes[1]];
    }

    public int getMaxIndex() {
        if(this.isEmpty())
            return -1;
        return this.indexes[1]-1;
    }

    public Item getItem(int i) {
        this.checkIndex(i++);
        return this.data[i];
    }

    public Item extractMax() {
        if(this.isEmpty())
            throw new RuntimeException("Empty " + this.getClass().getSimpleName());
        Item ret = this.data[this.indexes[1]];

        this.swapIndexes(1, this.size);
        this.size--;
        this.shiftDown(1);
        return ret;
    }

    public int extractMaxIndex() {
        if(this.isEmpty())
            throw new RuntimeException("Empty " + this.getClass().getSimpleName());

        int ret = this.indexes[1];

        this.swapIndexes(1, this.size);
        this.size--;
        shiftDown(1);
        return ret-1;
    }

    public void insert(int i, Item item) {
        if (this.size + 1 > capacity )
            throw new RuntimeException(this.getClass().getSimpleName() + " is full capacity: " + this.capacity);
        this.checkIndex(i);

        this.data[++i] = item;
        this.indexes[++this.size] = i;
        this.shiftUp(this.size);
    }

    private void shiftUp(int i) {
        while(i > 1 && this.data[this.indexes[i]].compareTo(this.data[this.indexes[i/2]]) > 0) {
            this.swapIndexes(i, i/2);
            i = i/2;
        }
    }

    private void shiftDown(int i) {

        while(i*2 <=this.size) {
            int child = i * 2;
            if(child + 1 <= this.size && this.data[this.indexes[child+1]].compareTo(this.data[this.indexes[child]]) > 0)
                child++;
            if(this.data[this.indexes[child]].compareTo(this.data[this.indexes[i]]) <= 0)
                break;
            this.swapIndexes(i, child);
            i = child;
        }
    }

    private void swapIndexes(int a, int b) {
        if(a != b) {
            int temp = this.indexes[a];
            this.indexes[a] = this.indexes[b];
            this.indexes[b] = temp;
        }
    }

    private void checkIndex(int i) {
        if (i < 0 || i+1 > this.capacity)
            throw new IllegalArgumentException("Invalid Index: " + i);
    }

    public void change( int i , Item newItem ) {
        this.checkIndex(i++);
        for(int j=1;j<this.indexes.length;j++)
            if(this.indexes[j] == i) {
                this.data[i] = newItem;
                this.shiftDown(j);
                this.shiftUp(j);
                return;
            }

    }

    public void echo() {
        Integer[] temp = new Integer[this.indexes.length];
        for(int i=0;i<temp.length;i++)
            temp[i] = this.indexes[i];
        PrintHelper.echoLn("\r\nIndex:");
        ArrayHelper.echo(temp);
        PrintHelper.echoLn("Data:");
        ArrayHelper.echo(this.data);
        PrintHelper.echoLn("");
    }

    public boolean testIndexes(){
        int[] copyIndexes = new int[this.size+1];
        for( int i = 0 ; i <= this.size ; i ++ )
            copyIndexes[i] = indexes[i];
        copyIndexes[0] = 0;
        Arrays.sort(copyIndexes);
        boolean res = true;
        for( int i = 1 ; i <= this.size ; i ++ )
            if( copyIndexes[i-1] + 1 != copyIndexes[i] ){
                res = false;
                break;
            }

        if( !res ){
            PrintHelper.echoLn("Error!");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int N = 10;
        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<>(N);
        for( int i = 0 ; i < N ; i ++ )
            indexMaxHeap.insert( i , (int)(Math.random()*N) );

        PrintHelper.echoLn(indexMaxHeap.testIndexes());

        indexMaxHeap.echo();
        PrintHelper.echoLn("GetMax: " + indexMaxHeap.getMax());
        int maxIndex = indexMaxHeap.extractMaxIndex();
        PrintHelper.echoLn("ExtractMaxIndex: " + maxIndex);
        PrintHelper.echoLn("ExtractMax: " + indexMaxHeap.getItem(maxIndex));
        indexMaxHeap.echo();

        for(int i=0;i<N-1;i++) {
            PrintHelper.echoLn(indexMaxHeap.extractMax() + " size: " + indexMaxHeap.size());
            indexMaxHeap.echo();
        }

        PrintHelper.echoLn(indexMaxHeap.getItem(0));
        indexMaxHeap.echo();
    }
}