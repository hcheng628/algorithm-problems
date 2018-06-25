package us.supercheng.algorithm.data.structure.set;

import us.supercheng.algorithm.data.structure.list.MyLinkedList;

public class MyLinkedListSet<E extends Comparable<E>> implements Set<E> {

    private MyLinkedList<E> linkedList;

    public MyLinkedListSet() {
        this.linkedList = new MyLinkedList<>();
    }

    @Override
    public void add(E e) {
        if(!this.contains(e))
            this.linkedList.addFirst(e); // ???
    }

    @Override
    public boolean contains(E e) {
        return this.linkedList.contains(e);
    }

    @Override
    public void remove(E e) {
        this.linkedList.removeElement(e);
    }

    @Override
    public int getSize() {
        return this.linkedList.getSize();

    }

    @Override
    public boolean isEmpty() {
        return this.linkedList.isEmpty();
    }
}