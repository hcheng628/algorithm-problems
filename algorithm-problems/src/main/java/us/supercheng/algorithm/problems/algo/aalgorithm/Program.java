package us.supercheng.algorithm.problems.algo.aalgorithm;

import java.util.*;

public class Program {

    // Time: O(m*n * log(m*n))  Space: O(m*n)
    public int[][] aStarAlgorithm(int startRow, int startCol, int endRow, int endCol, int[][] graph) {
        int rowLen = graph.length;
        int colLen = graph[0].length;
        final int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        MinHeap heap = new MinHeap();
        Info[][] mat = this.buildMat(graph, rowLen, colLen, endRow, endCol);

        Info start = mat[startRow][startCol];
        start.updateSteps(0);
        heap.insert(start);

        while (!heap.isEmpty()) {
            Info curr = heap.remove();
            int[] from = new int[]{curr.r, curr.c};

            for (int[] dir : DIRS) {
                int newR = curr.r + dir[0];
                int newC = curr.c + dir[1];

                if (newR < 0 || newC < 0 || newR >= rowLen || newC >= colLen || graph[newR][newC] == 1)
                    continue;

                Info next = mat[newR][newC];
                if (next.steps == null || curr.steps + 1 < next.steps) {
                    next.updateSteps(curr.steps + 1);
                    next.from = from;

                    if (newR == endRow && newC == endCol)
                        return this.buildRes(startRow, startCol, endRow, endCol, mat);

                    heap.insert(next);
                }
            }
        }

        return new int[][] {};
    }

    class Info {
        int r;
        int c;
        int val;
        Integer steps;
        int hVal;
        int total;
        int[] from;

        Info (int endRow, int endCol, int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
            this.hVal = Math.abs(this.r - endRow) + Math.abs(this.c - endCol);
        }

        void updateSteps(int newSteps) {
            this.steps = newSteps;
            this.total = this.steps + this.hVal;
        }
    }

    private Info[][] buildMat(int[][] graph, int rowLen, int colLen, int endRow, int endCol) {
        Info[][] ret = new Info[rowLen][colLen];

        for (int i=0; i<rowLen; i++)
            for (int j=0; j<colLen; j++)
                ret[i][j] = new Info(endRow, endCol, i, j, graph[i][j]);

        return ret;
    }

    private int[][] buildRes(int startRow, int startCol, int endRow, int endCol, Info[][] mat) {
        List<int[]> list = new ArrayList<>();

        for (int rr = endRow, cc = endCol; mat[rr][cc].from != null; ) {
            Info info = mat[rr][cc];
            list.add(new int[]{rr, cc});
            rr = info.from[0];
            cc = info.from[1];
        }

        list.add(new int[]{startRow, startCol});

        int size = list.size();
        int[][] ret = new int[size][2];

        for (int i=size-1; i>-1; i--)
            ret[size - i - 1] = list.get(i);

        return ret;
    }

    class MinHeap {

        List<Info> heap;

        public MinHeap() {
            this.heap = new ArrayList<>();
        }

        public void siftDown(int currentIdx, int endIdx, List<Info> heap) {
            if (!this.hasLeftChild(currentIdx))
                return;

            if (!this.hasRightChild(currentIdx)) {
                int left = this.leftChild(currentIdx);
                int leftVal = this.heap.get(left).total;
                int val = this.heap.get(currentIdx).total;

                if (leftVal < val) {
                    this.swap(left, currentIdx);
                    this.siftDown(left, endIdx, this.heap);
                }
            } else {
                int left = this.leftChild(currentIdx);
                int right = this.rightChild(currentIdx);
                int leftVal = this.heap.get(left).total;
                int rightVal = this.heap.get(right).total;
                int val = this.heap.get(currentIdx).total;

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

        public void siftUp(int currentIdx, List<Info> heap) {
            if (!this.hasParent(currentIdx))
                return;

            int p = this.parent(currentIdx);
            if (this.heap.get(currentIdx).total < this.heap.get(p).total) {
                this.swap(currentIdx, p);
                this.siftUp(p, this.heap);
            }
        }

        public Info peek() {
            if (this.heap.isEmpty())
                throw new RuntimeException("Empty Min Stack");
            return this.heap.get(0);
        }

        public Info remove() {
            Info ret = this.heap.get(0);
            this.heap.set(0, this.heap.get(this.heap.size() - 1));
            this.heap.remove(this.heap.size() - 1);
            this.siftDown(0, this.heap.size() - 1, this.heap);
            return ret;
        }

        public void insert(Info value) {
            this.heap.add(value);
            this.siftUp(this.heap.size() - 1, this.heap);
        }

        public boolean isEmpty() {
            return this.heap.isEmpty();
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

        private void swap(int x, int y) {
            if (x < 0 || y < 0 || x >= this.heap.size() || y >= this.heap.size() || x == y)
                return;

            Info tmp = this.heap.get(x);
            this.heap.set(x, this.heap.get(y));
            this.heap.set(y, tmp);
        }

        private boolean isValidIdx(int idx) {
            return !this.heap.isEmpty() && idx > -1 && idx < this.heap.size();
        }

    }

}
