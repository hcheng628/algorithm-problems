package us.supercheng.algorithm.problems.algo.minheapconstruction;

import java.util.*;

public class Program {

    static class MinHeap {

        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            for (int a : array)
                this.insert(a);

            return this.heap;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            if (!this.hasLeftChild(currentIdx))
                return;

            if (!this.hasRightChild(currentIdx)) {
                int left = this.leftChild(currentIdx);
                int leftVal = this.heap.get(left);
                int val = this.heap.get(currentIdx);

                if (leftVal < val) {
                    this.swap(left, currentIdx);
                    this.siftDown(left, endIdx, this.heap);
                }
            } else {
                int left = this.leftChild(currentIdx);
                int right = this.rightChild(currentIdx);
                int leftVal = this.heap.get(left);
                int rightVal = this.heap.get(right);
                int val = this.heap.get(currentIdx);

                if (leftVal <= rightVal) {
                    if (leftVal < val) {
                        this.swap(left, currentIdx);
                        this.siftDown(left, endIdx, this.heap);
                    }
                } else {
                    if (rightVal < val) {
                        this.swap(right, currentIdx);
                        this.siftDown(right, endIdx, this.heap);
                    }
                }
            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            if (!this.hasParent(currentIdx))
                return;

            int p = this.parent(currentIdx);
            if (this.heap.get(currentIdx) < this.heap.get(p)) {
                this.swap(currentIdx, p);
                this.siftUp(p, this.heap);
            }
        }

        public int peek() {
            if (this.heap.isEmpty())
                throw new RuntimeException("Empty Min Stack");
            return this.heap.get(0);
        }

        public int remove() {
            this.checkHeap();
            int ret = this.heap.get(0);
            this.heap.set(0, this.heap.get(this.heap.size() - 1));
            this.heap.remove(this.heap.size() - 1);
            this.siftDown(0, this.heap.size() - 1, this.heap);

            return ret;
        }

        public void insert(int value) {
            this.heap.add(value);
            this.siftUp(this.heap.size() - 1, this.heap);
        }

        private int parent(int idx) {
            if (idx % 2 == 0)
                idx--;
            return idx / 2;
        }

        private boolean hasParent(int idx) {
            return idx > 0 && idx < this.heap.size();
        }

        private int leftChild(int idx) {
            return idx * 2 + 1;
        }

        private int rightChild(int idx) {
            return this.leftChild(idx) + 1;
        }

        private boolean hasLeftChild(int idx) {
            return this.isValidIdx(this.leftChild(idx));
        }

        private boolean hasRightChild(int idx) {
            return this.isValidIdx(this.rightChild(idx));
        }

        private void checkHeap() {
            if (this.heap.isEmpty())
                throw new RuntimeException("Empty Min Stack");
        }

        private void swap(int x, int y) {
            if (x < 0 || y < 0 || x >= this.heap.size() || y >= this.heap.size() || x == y)
                return;

            int tmp = this.heap.get(x);
            this.heap.set(x, this.heap.get(y));
            this.heap.set(y, tmp);
        }

        private boolean isValidIdx(int idx) {
            return !this.heap.isEmpty() &&
                    idx > -1 &&
                    idx < this.heap.size();
        }

    }
}
