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
        if(this.dummyTail.next == null) {
            this.dummyTail.next = new MyNode<>(e);
            this.dummyHead.next = this.dummyTail.next;
        } else {
            MyNode<E> oldTail = this.dummyTail.next;
            MyNode<E> newNode = new MyNode<>(e);
            this.dummyTail.next = newNode;
            oldTail.next = newNode;
        }
        this.size++;
    }

    @Override
    public E dequeue() {
        if(size < 1)
            throw new IllegalArgumentException("Cannot Dequeue on Empty Queue");
        MyNode<E> delNode = this.dummyHead.next;
        this.dummyHead.next = this.dummyHead.next.next;
        if(this.dummyHead.next == null)
            this.dummyTail.next = null; // To Reset LinkedListQueue
        delNode.next = null;
        this.size--;
        return delNode.val;
    }

    @Override
    public E getFront() {
        return this.dummyHead.next.val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedListQueue [");
        MyNode<E> head = this.dummyHead.next;
        E headVal = null;
        E tailVal = null;
        if(head != null)
            headVal = head.val;

        for(int i=0;i<size&&head!=null;i++) {
            if(i == size -1) {
                sb.append(head.val);
                tailVal = head.val;
            } else
                sb.append(head.val + ",");
            head = head.next;
        }
        sb.append("] Head: " + headVal + " Tail: " + tailVal);
        return sb.toString();
    }
}