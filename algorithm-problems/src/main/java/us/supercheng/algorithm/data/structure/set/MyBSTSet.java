package us.supercheng.algorithm.data.structure.set;

import us.supercheng.algorithm.data.structure.tree.MyBST;

public class MyBSTSet<E extends Comparable<E>> implements Set<E> {

    private MyBST<E> bst;

    public MyBSTSet() {
        this.bst = new MyBST();
    }

    @Override
    public void add(E e) {
        this.bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return this.bst.contains(e);
    }

    @Override
    public void remove(E e) {
        this.bst.delElement(e);
    }

    @Override
    public int getSize() {
        return this.bst.size();
    }

    @Override
    public boolean isEmpty() {
        return this.isEmpty();
    }
}