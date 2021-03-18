package us.supercheng.algorithm.problems.algo.mergesortedarrays;

import java.util.ArrayList;
import java.util.List;

public class Program {

    // Time: O(m*n) Space: O(m+n)
    public static List<Integer> mergeSortedArrays_Solution1(List<List<Integer>> arrays) {
        List<Integer> ret = new ArrayList<>();
        int len = arrays.size();
        int[] indice = new int[len];

        while (true) {
            int minIdx = -1;
            int minVal = -1;

            for (int i=0; i<len; i++) {
                List<Integer> arr = arrays.get(i);
                int idx = indice[i];

                if (idx < arr.size()) {
                    int val = arr.get(idx);
                    if (minIdx == -1 || (minIdx != -1 && val < minVal)) {
                        minIdx = i;
                        minVal = val;
                    }
                }
            }

            if (minIdx == -1)
                break;
            indice[minIdx]++;
            ret.add(minVal);
        }

        return ret;
    }

    // Time: O(m*n*log(m*n) Space: O(m*n)
    public static List<Integer> mergeSortedArrays_Solution2(List<List<Integer>> arrays) {
        List<Integer> ret = new ArrayList<>();
        MinHeap heap = new MinHeap();

        for (List<Integer> arr : arrays)
            for (int a : arr)
                heap.add(a);

        while (!heap.isEmpty())
            ret.add(heap.pollMin());

        return ret;
    }

    static class MinHeap {
        List<Integer> list;

        MinHeap() {
            this.list = new ArrayList<>();
        }

        void add(int val) {
            this.list.add(val);

            if (this.list.size() > 1)
                for (int curr = this.list.size() - 1; curr != -1; ) {
                    int parentIdx = getParentIdx(curr);
                    if (parentIdx != -1) {
                        if (this.list.get(parentIdx) > this.list.get(curr))
                            this.swap(curr, parentIdx);
                        else
                            break;
                    }
                    curr = parentIdx;
                }
        }

        int pollMin() {
            int ret = this.list.get(0);

            int last = this.list.size() - 1;
            this.swap(0, last);
            this.list.remove(last);

            if (!this.isEmpty())
                this.heapify(0);

            return ret;
        }

        boolean isEmpty() {
            return this.list.isEmpty();
        }

        private void heapify(int idx) {
            if (idx < 0 || idx >= this.list.size())
                return;

            int leftIdx = this.getLeftChildIdx(idx);
            int rightIdx = this.getRightChildIdx(idx);
            int currVal = this.list.get(idx);

            if (leftIdx != -1 && rightIdx != -1) {
                int leftVal = this.list.get(leftIdx);
                int rightVal = this.list.get(rightIdx);
                if (leftVal < rightVal) {
                    if (leftVal < currVal) {
                        this.swap(leftIdx, idx);
                        this.heapify(leftIdx);
                    }
                } else {
                    if (rightVal < currVal) {
                        this.swap(rightIdx, idx);
                        this.heapify(rightIdx);
                    }
                }
            } else if (leftIdx != -1 && this.list.get(leftIdx) < currVal) {
                this.swap(leftIdx, idx);
                this.heapify(leftIdx);
            } else if (rightIdx != -1 && this.list.get(rightIdx) < currVal) {
                this.swap(rightIdx, idx);
                this.heapify(rightIdx);
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
            if (idx < 1)
                return -1;
            return idx % 2 == 0 ? (idx - 1) / 2 : idx / 2;
        }

        private void swap(int a, int b) {
            if (a != b) {
                int valA = this.list.get(a);
                int valB = this.list.get(b);
                if (valA != valB) {
                    this.list.set(a, valB);
                    this.list.set(b, valA);
                }
            }
        }

        public String toString() {
            return this.list.toString();
        }

    }

}
