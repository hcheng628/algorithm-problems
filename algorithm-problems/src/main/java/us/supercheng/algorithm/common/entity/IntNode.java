package us.supercheng.algorithm.common.entity;

public class IntNode {
    private Integer val;
    private IntNode node;

    public IntNode() {
        this.val = null;
        this.node = null;
    }

    public IntNode(Integer val) {
        this.val = val;
        this.node = null;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public IntNode getNode() {
        return node;
    }

    public void setNode(IntNode node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "IntNode{" +
                "val=" + val +
                '}';
    }

    public static void printList(IntNode node){
        while (node != null) {
            System.out.print(node + " ");
            node = node.getNode();
        }
        System.out.println();
    }
}