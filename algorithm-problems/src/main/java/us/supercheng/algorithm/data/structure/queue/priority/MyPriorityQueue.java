package us.supercheng.algorithm.data.structure.queue.priority;

import us.supercheng.algorithm.data.structure.queue.Queue;

public class MyPriorityQueue<E extends Comparable<E>> implements Queue<E>{

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enqueue(E e) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }
}