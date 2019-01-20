package us.supercheng.algorithm.common.entity;

public class Node<Key extends Comparable, Value> {
    public Key k;
    public Value v;

    public Node left, right;

    public Node(Key kk, Value vv) {
        this.k = kk;
        this.v = vv;
    }
}