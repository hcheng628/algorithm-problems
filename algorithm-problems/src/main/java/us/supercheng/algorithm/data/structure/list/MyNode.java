package us.supercheng.algorithm.data.structure.list;

public class MyNode<E> {
    public E val;
    public MyNode<E> next;

    public MyNode() {
        this(null, null);
    }

    public MyNode(E e) {
        this(e, null);
    }

    public MyNode(E e, MyNode<E> next) {
        this.val = e;
        this.next = next;
    }

    @Override
    public String toString() {
        return this.val.toString();
    }
}