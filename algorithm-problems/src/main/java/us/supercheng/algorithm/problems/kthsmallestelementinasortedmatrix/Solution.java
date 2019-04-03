package us.supercheng.algorithm.problems.kthsmallestelementinasortedmatrix;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 1)
            return matrix[0][0];

        Queue<Integer> queue = new PriorityQueue<>(1, (x, y) -> y - x);
        for (int i=0;i<matrix.length;i++)
            for (int j=0;j<matrix.length;j++) {
                queue.add(matrix[i][j]);
                if (queue.size()>k)
                    queue.poll();
            }

        return queue.peek();
    }
}