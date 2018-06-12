package us.supercheng.algorithm.data.structure.tree;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class MyBST<E extends Comparable<E>> {

    private MyTreeNode<E> root;
    private int size;

    public MyBST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void add(E e) {
        this.root = this.add(this.root, e);
    }

    private MyTreeNode<E> add(MyTreeNode<E> node, E e) {
        if (node == null) {
            this.size++;
            return new MyTreeNode<>(e);
        }
        if (node.val.compareTo(e
        ) > 0)
            node.left = this.add(node.left, e);
        else if (node.val.compareTo(e) < 0)
            node.right = this.add(node.right, e);
        return node;
    }

    public boolean contains(E e) {
        return this.contains(this.root, e);
    }

    private boolean contains(MyTreeNode<E> node, E e) {
        if(node == null)
            return false;
        if(node.val.equals(e))
            return true;
        else if (node.val.compareTo(e) > 0)
            return this.contains(node.left, e);
        else
            return this.contains(node.right, e);
    }

    public void test() {
        PrintHelper.echoLn("Root: " + this.root.val);
        PrintHelper.echoLn("Left: " + this.root.left.val);
        PrintHelper.echoLn("Right: " + this.root.right.val);

    }
}