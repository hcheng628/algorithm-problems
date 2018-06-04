package us.supercheng.algorithm.data.structure.stack;

import us.supercheng.algorithm.data.structure.list.MyLinkedList;

public class MyLinkedListStack<E> implements Stack<E> {

    private MyLinkedList<E> list;

    public MyLinkedListStack() {
        this.list = new MyLinkedList<>();
    }

    @Override
    public int getSize() {
        return this.list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public void push(E e) {
        this.list.addFirst(e);
    }

    @Override
    public E pop() {
        if(this.list.isEmpty())
            throw new IllegalArgumentException("Invalid Operation: Cannot Pop Empty Stack");
        return this.list.removeFirst();
    }

    @Override
    public E peek() {
        return this.list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack Top: " + this.list.toString() + " Bottom");
        return sb.toString();
    }
}
