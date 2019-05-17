package us.supercheng.algorithm.common.entity;

public class NodeV1 {
    public int val;
    public NodeV1 prev;
    public NodeV1 next;
    public NodeV1 child;

    public NodeV1() {}

    public NodeV1(int _val, NodeV1 _prev, NodeV1 _next, NodeV1 _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}