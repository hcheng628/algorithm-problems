package us.supercheng.algorithm.data.structure.queue;

import us.supercheng.algorithm.data.structure.list.MyNode;

public class LinkedListQueue<E> implements Queue<E> {

    private MyNode<E> dummyHead;
    private MyNode<E> dummyTail;
    private int size;

    public LinkedListQueue() {
        this.dummyHead = new MyNode<>(null);
        this.dummyTail = new MyNode<>(null);
        this.size = 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void enqueue(E e) {
        MyNode<E> node = this.dummyHead.next;
        while(node != null)
            node = node.next;
        node.next = new MyNode<>(e, node.next);
        this.size++;
        this.dummyTail = node.next;
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