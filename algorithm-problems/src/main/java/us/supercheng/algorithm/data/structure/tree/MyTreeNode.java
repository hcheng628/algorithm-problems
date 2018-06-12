package us.supercheng.algorithm.data.structure.tree;

public class MyTreeNode<E> {

    public E val;
    public MyTreeNode left, right;

    public MyTreeNode(E e) {
        this.val = e;
        this.left = null;
        this.right = null;
    }
}