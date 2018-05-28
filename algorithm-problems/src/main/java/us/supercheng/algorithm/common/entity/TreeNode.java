package us.supercheng.algorithm.common.entity;

public class TreeNode {

    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public Integer getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}