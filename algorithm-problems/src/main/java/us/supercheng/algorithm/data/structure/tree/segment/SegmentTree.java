package us.supercheng.algorithm.data.structure.tree.segment;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class SegmentTree<E> {

    private E [] data;
    private E [] tree;
    private Merger<E> merger;

    public SegmentTree(E [] data, Merger<E> merger) {
        this.data = (E []) new Object[data.length];
        for(int i=0;i<data.length;i++)
            this.data[i] = data[i];
        this.tree = (E []) new Object[data.length*4];
        this.merger = merger;
        this.buildSegmentTree(0, 0, this.data.length-1);
    }

    private void buildSegmentTree(int index, int l, int r) {
        if(l == r) {
            this.tree[index] = this.data[l];
            return;
        }

        int mid = l + (r - l) /2,
                leftIndex = this.getLeftChildIndex(index),
                rightIndex = this.getRightChildIndex(index);
        this.buildSegmentTree(leftIndex,l,mid);
        this.buildSegmentTree(rightIndex,mid+1,r);
        this.tree[index] = this.merger.merge(this.tree[leftIndex], this.tree[rightIndex]);
    }

    private int getSize() {
        return data.length;
    }

    private E get(int index) {
        if(index < 0 || index >= this.data.length)
            throw new IllegalArgumentException("Invalid Index");
        return this.data[index];
    }

    private int getLeftChildIndex(int root) {
        return root * 2 + 1;
    }


    private int getRightChildIndex(int root) {
        return root * 2 + 2;
    }

    public E getRange(int left, int right) {
        return this.getRange(0, 0, this.data.length-1, left, right);
    }

    private E getRange(int rootIndex, int leftIndex, int rightIndex, int left, int right) {
        if(leftIndex == left && rightIndex == right) {
            return this.tree[rootIndex];
        }

        int mid = leftIndex + (rightIndex - leftIndex) / 2;
        if(left > mid) {
            return this.getRange(this.getRightChildIndex(rootIndex), left, rightIndex, left, right);
        } else if (right <= mid) {
            return this.getRange(this.getLeftChildIndex(rootIndex), leftIndex, right, left, right);
        }

        E leftPart = this.getRange(this.getLeftChildIndex(rootIndex), leftIndex, mid, left, mid);
        E rightPart = this.getRange(this.getRightChildIndex(rootIndex), mid+1, rightIndex, mid+1, right);

        return this.merger.merge(leftPart, rightPart);
    }

    private void setRange(int left, int right) {

    }

    public void echo() {
        int height = 1;
        for(int i=0;i<this.tree.length;i++) {
            if(i == height-1) {
                PrintHelper.echoLn("");
                height *= 2;
            }
            PrintHelper.echo(this.tree[i] + ", ");
        }
    }
}