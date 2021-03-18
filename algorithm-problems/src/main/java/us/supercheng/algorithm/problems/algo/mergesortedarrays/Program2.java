package us.supercheng.algorithm.problems.algo.mergesortedarrays;

import java.util.*;


public class Program2 {

    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        List<Integer> ret = new ArrayList<Integer>();
        MinHeap minHeap = new MinHeap();

        for (int i=0, len=arrays.size(); i<len; i++)
            minHeap.add(new Node(i, 0, arrays.get(i).get(0)));

        while (!minHeap.isEmpty()) {
            Node n = minHeap.pollMin();
            int parentIdx = n.parentIdx;
            int idx = n.idx;
            ret.add(n.val);

            List<Integer> list = arrays.get(parentIdx);
            if (idx + 1 < list.size())
                minHeap.add(new Node(parentIdx, idx + 1, list.get(idx + 1)));
        }

        return ret;
    }


    static class Node {
        int parentIdx;
        int idx;
        int val;

        public Node(int parentIdx, int idx, int val) {
            this.parentIdx = parentIdx;
            this.idx = idx;
            this.val = val;
        }
    }

    static class MinHeap {
        List<Node> list;

        public MinHeap() {
            this.list = new ArrayList<>();
        }

        public void add(Node n) {
            this.list.add(n);
            if (this.list.size() > 1) {
                this.shiftUp(this.list.size() - 1);
            }
        }

        public Node pollMin() {
            Node ret = this.list.get(0);
            int lastIdx = this.list.size() - 1;
            this.swap(0, lastIdx);
            this.list.remove(lastIdx);

            if (this.list.size() > 1)
                this.shiftDown(0);

            return ret;
        }

        private void shiftUp(int idx) {
            int parentIdx = this.getParentIdx(idx);
            if (parentIdx == -1)
                return;

            Node parentVal = this.list.get(parentIdx);
            Node currVal = this.list.get(idx);

            if (parentVal.val > currVal.val) {
                this.swap(parentIdx, idx);
                this.shiftUp(parentIdx);
            }
        }

        private void shiftDown(int idx) {
            int leftIdx = this.getLeftChildIdx(idx);
            int rightIdx = this.getRightChildIdx(idx);

            if (leftIdx != -1 && rightIdx != -1) {
                Node leftVal = this.list.get(leftIdx);
                Node rightVal = this.list.get(rightIdx);
                Node currVal = this.list.get(idx);
                if (leftVal.val < rightVal.val && leftVal.val < currVal.val) {
                    this.swap(leftIdx, idx);
                    this.shiftDown(leftIdx);
                } else if (rightVal.val < currVal.val) {
                    this.swap(rightIdx, idx);
                    this.shiftDown(rightIdx);
                }
            } else if (leftIdx != -1 && this.list.get(leftIdx).val < this.list.get(idx).val) {
                this.swap(leftIdx, idx);
                this.shiftDown(leftIdx);
            }
        }

        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        private void swap(int a, int b) {
            if (a > -1 && b > -1 && a < this.list.size() && b < this.list.size() && a != b) {
                Node nodeA = this.list.get(a);
                this.list.set(a, this.list.get(b));
                this.list.set(b, nodeA);
            }
        }

        private int getLeftChildIdx(int idx) {
            int ret = idx * 2 + 1;
            return ret > -1 && ret < this.list.size() ? ret : -1;
        }

        private int getRightChildIdx(int idx) {
            int ret = idx * 2 + 2;
            return ret > -1 && ret < this.list.size() ? ret : -1;
        }

        private int getParentIdx(int idx) {
            return idx < 1 ? - 1 : (idx - 1) / 2;
        }

    }
}


