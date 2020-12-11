package us.supercheng.algorithm.problems.leetcode.rleiterator;

public class RLEIterator {

    private int[] arr;
    private int idx;
    private int count;
    private int num;

    public RLEIterator(int[] A) {
        this.arr = A;
    }

    public int next(int n) {
        if (this.idx >= arr.length && this.count < n) {
            this.count = 0;
            return this.num = -1;
        } else if (count >= n) {
            this.count -= n;
            return this.num;
        } else {
            n -= this.count;
            int total = 0;

            while (total < n && this.idx < this.arr.length) {
                int c = this.arr[this.idx++];
                total += c;
                this.count = c;
                this.num = this.arr[this.idx++];
            }
            this.count = total - n;
            return this.num;
        }
    }
}