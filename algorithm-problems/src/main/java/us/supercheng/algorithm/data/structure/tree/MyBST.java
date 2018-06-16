package us.supercheng.algorithm.data.structure.tree;

import us.supercheng.algorithm.common.helper.PrintHelper;
import us.supercheng.algorithm.data.structure.queue.MyLinkedListQueue;
import us.supercheng.algorithm.data.structure.stack.MyLinkedListStack;

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
        if (node.val.compareTo(e) > 0)
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

    @Override
    public String toString() {
        return this.traverseNodes(this.root, "");
    }

    private String traverseNodes(MyTreeNode node, String s) {
        if(node == null)
            return "";
        String sS = node.val.toString();
        this.traverseNodes(node.left, s + "\n" + sS);
        this.traverseNodes(node.right, s+ "\n" + sS);
        return sS;
    }

    public String echoInOrder() {
        return this.echoInOrder(this.root, new StringBuilder());
    }

    public String echoInOrder(MyTreeNode node, StringBuilder sb) {
        if(node==null)
            return "";
        this.echoInOrder(node.left, sb);
        sb.append(node.val);
        this.echoInOrder(node.right, sb);
        return sb.toString();
    }

    public String echoPreOrder() {
        return this.echoPreOrder(this.root, new StringBuilder());
    }

    private String echoPreOrder(MyTreeNode node, StringBuilder sb) {
        if(node == null)
            return "";
        sb.append(node.val);
        this.echoPreOrder(node.left, sb);
        this.echoPreOrder(node.right, sb);
        return sb.toString();
    }

    public String echoPostOrder() {
        return this.echoPostOrder(this.root, new StringBuilder());
    }

    private String echoPostOrder(MyTreeNode node, StringBuilder sb) {
        if(node == null)
            return "";
        this.echoPostOrder(node.left, sb);
        this.echoPostOrder(node.right, sb);
        sb.append(node.val);
        return sb.toString();
    }

    public String echoOrderLevel() {
        StringBuilder sb = new StringBuilder();
        MyLinkedListQueue<MyTreeNode> queue = new MyLinkedListQueue<>();
        if(this.root != null)
            queue.enqueue(this.root);
        while (!queue.isEmpty()) {
            MyTreeNode node = queue.dequeue();
            if(node != null)
                sb.append(node.val);
            if(node.left != null)
                queue.enqueue(node.left);
            if(node.right != null)
                queue.enqueue(node.right);
        }
        return sb.toString();
    }

    public String echoPreOrderNR() {
        StringBuilder sb = new StringBuilder();
        MyLinkedListStack<MyTreeNode> stack = new MyLinkedListStack<>();
        if(this.root != null)
            stack.push(this.root);
        while (!stack.isEmpty()) {
            MyTreeNode node = stack.pop();
            if(node != null)
                sb.append(node.val);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        return sb.toString();
    }

    public E getMin() {
        return this.getMin(this.root).val;
    }

    private MyTreeNode<E> getMin(MyTreeNode<E> node) {
        if(this.isEmpty())
            throw new IllegalArgumentException("Empty Tree No Min Element Exists");
        if(node.left == null)
            return node;
        return this.getMin(node.left);
    }

    public E getMinNR() {
        MyTreeNode<E> node = this.root;
        if(node == null)
            return null;

        while(node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    public E getMaxNR() {
        MyTreeNode<E> node = this.root;
        if(node == null)
            return null;

        while(node.right != null) {
            node = node.right;
        }
        return node.val;
    }

    public E getMax() {
        return this.getMax(this.root).val;
    }

    private MyTreeNode<E> getMax(MyTreeNode node) {
        if(this.isEmpty())
            throw new IllegalArgumentException("Empty Tree No Max Element Exists");
        if(node.right == null)
            return node;
        return this.getMax(node.right);
    }

    public E delMinElement() {
        E ret = this.getMin();
        this.delMinElement(this.root);
        return ret;
    }

    private MyTreeNode<E> delMinElement(MyTreeNode<E> node) {
        if(isEmpty())
            throw new IllegalArgumentException("Empty Tree Cannot Delete Min Element");
        if(node.left == null) {
            MyTreeNode rightChild = node.right;
            this.size--;
            node.right = null;
            return rightChild;
        }
        node.left = this.delMinElement(node.left);
        return node;
    }

    public E delMaxElement() {
        E ret = this.getMax();
        this.delMaxElement(this.root);
        return ret;
    }

    private MyTreeNode<E> delMaxElement(MyTreeNode<E> node) {
        if(isEmpty())
            throw new IllegalArgumentException("Empty Tree Cannot Delete Max Element");
        if(node.right == null) {
            MyTreeNode leftChild = node.left;
            node.left = null;
            size--;
            return leftChild;
        }
        node.right = this.delMaxElement(node.right);
        return node;
    }

    public void delElement(E e) {
        if(e == null)
            throw new IllegalArgumentException("Cannot Delete Element null");
        if(isEmpty())
            throw new IllegalArgumentException("Cannot Delete Element in Empty Tree");
        this.root = this.delElement(this.root, e);
    }

    private MyTreeNode<E> delElement(MyTreeNode<E> head, E e) {
        if(head == null)
            return null;
        if(e.compareTo(head.val) > 0) {
            head.right = this.delElement(head.right, e);
            return head;
        } else if(e.compareTo(head.val) < 0) {
            head.left = this.delElement(head.left, e);
            return head;
        } else {
            if(head.left == null && head.right == null) {
                return null;
            } else if (head.left == null && head.right != null) {
                MyTreeNode<E> ret = head.right;
                head.right = null;
                this.size--;
                return ret;
            } else if (head.left != null && head.right == null) {
                MyTreeNode<E> ret = head.left;
                head.left = null;
                this.size--;
                return ret;
            } else {
                MyTreeNode<E> subMin = new MyTreeNode(this.getMax(head.left).val);
                this.size++;
                subMin.left = this.delMaxElement(head.left);
                subMin.right = head.right;
                head.left = head.right = null;
                this.size--;
                return subMin;
            }
        }
    }
}