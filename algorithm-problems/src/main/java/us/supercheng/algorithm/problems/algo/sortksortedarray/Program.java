package us.supercheng.algorithm.problems.algo.sortksortedarray;

import java.util.*;

public class Program {

    public int[] sortKSortedArray_Solution1(int[] array, int k) {
        if (array == null || array.length < 2)
            return array;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int len = array.length;
        int idx = 0;

        for (int i=0; i<=k && i<len; i++)
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);

        for (int end=len-k; idx<end; idx++) {
            array[idx] = map.firstKey();

            if (map.get(array[idx]) == 1)
                map.remove(array[idx]);
            else
                map.put(array[idx], map.get(array[idx]) - 1);
            if (idx + k + 1 < len)
                map.put(array[idx + k + 1], map.getOrDefault(array[idx + k + 1], 0) + 1);
        }

        for (; !map.isEmpty(); idx++) {
            array[idx] = map.firstKey();
            map.put(array[idx], map.get(array[idx]) - 1);
            if (map.get(array[idx]) == 0)
                map.remove(array[idx]);
        }

        return array;
    }

    public static void main(String[] args) {
        int[] res = new Program().sortKSortedArray(new int[]{3, 2, 1, 5, 4, 7, 6, 5}, 3);
        System.out.println(Arrays.toString(res));
    }

    public int[] sortKSortedArray(int[] array, int k) {
        if (array == null || array.length < 2)
            return array;

        int idx = 0;
        int len = array.length;
        MinHeap heap = new MinHeap();

        for (int i=0; i<len && i<=k; i++)
            heap.add(array[i]);

        for (int end=len-k; idx<end; idx++) {
            array[idx] = heap.popMin();
            if (idx + k + 1 < len)
                heap.add(array[idx + k + 1]);
        }

        while(heap.size() != 0)
            array[idx++] = heap.popMin();

        return array;
    }


    class MinHeap {
        private List<Integer> list;

        MinHeap() {
            this.list = new ArrayList<>();
        }

        private int leftChildIdx(int idx) {
            int ret = idx * 2 + 1;
            return ret < this.list.size() ? ret : - 1;
        }

        private int rightChildIdx(int idx) {
            int ret = idx * 2 + 2;
            return ret < this.list.size() ? ret : - 1;
        }

        private int parentIdx(int idx) {
            return idx == 0 ? -1 : (idx - 1) / 2;
        }

        public void add(int val) {
            if (list.isEmpty())
                list.add(val);
            else {
                list.add(val);
                int lastIdx = list.size() - 1;
                while (lastIdx > 0 && list.get(lastIdx) < list.get(parentIdx(lastIdx))) {
                    int parentIdx = parentIdx(lastIdx);
                    this.swap(lastIdx, parentIdx);
                    lastIdx = parentIdx;
                }
            }
        }

        private void heapify(int idx) {
            int leftIdx = leftChildIdx(idx);
            int rightIdx = rightChildIdx(idx);
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
            } else if (leftIdx != -1) {
                int leftVal = this.list.get(leftIdx);
                if (leftVal < currVal) {
                    this.swap(leftIdx, idx);
                    this.heapify(leftIdx);
                }
            } else if (rightIdx != -1) {
                int rightVal = this.list.get(rightIdx);
                if (rightVal < currVal) {
                    this.swap(rightIdx, idx);
                    this.heapify(rightIdx);
                }
            }
        }

        public int popMin() {
            int ret = this.list.get(0);
            this.swap(0, this.list.size() - 1);
            this.list.remove(this.list.size() - 1);

            if (this.list.size() > 1)
                this.heapify(0);

            return ret;
        }

        public int size() {
            return this.list.size();
        }

        private void swap(int a, int b) {
            if (a == b || this.list.get(a) == this.list.get(b))
                return;
            int tmp = this.list.get(a);
            this.list.set(a, this.list.get(b));
            this.list.set(b, tmp);
        }

        public String toString() {
            return this.list.toString();
        }
    }

}
