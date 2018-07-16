package us.supercheng.algorithm.data.structure.queue.priority;

import us.supercheng.algorithm.data.structure.queue.Queue;

public class MyPriorityQueue<E extends Comparable<E>> implements Queue<E>{

    MyMaxHeap<E> heap;

    public MyPriorityQueue() {
        this.heap = new MyMaxHeap<>();
    }

    @Override
    public int getSize() {
        return this.heap.size();
    }

    @Override
    public boolean isEmpty() {
        return this.heap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        this.heap.add(e);
    }

    @Override
    public E dequeue() {
        return this.heap.extractTop();
    }

    @Override
    public E getFront() {
        return this.heap.getTop();
    }
}