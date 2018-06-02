package us.supercheng.algorithm.data.structure.queue;

import us.supercheng.algorithm.data.structure.array.MyArray;

public class MyArrayQueue<E> implements Queue<E> {

    private MyArray<E> arr;

    public MyArrayQueue() {
        this.arr = new MyArray<>();
    }

    @Override
    public int getSize() {
        return this.arr.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.arr.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        this.arr.addLast(e);
    }

    @Override
    public E dequeue() {
        return this.arr.removeFirst();
    }

    @Override
    public E getFront() {
        return this.arr.get(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("My Array Queue Front [");
        for(int i=0;i<this.arr.getSize();i++)
            sb.append(i == this.getSize()-1 ? this.arr.get(i) : this.arr.get(i) + ",");
        sb.append("] End");
        return sb.toString();
    }
}
