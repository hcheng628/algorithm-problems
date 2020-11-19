package us.supercheng.algorithm.problems.shortestbridge;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int shortestBridge(int[][] A) {
        Queue<Integer> q = new LinkedList<>();
        int row = A.length,
            col = A[0].length,
            ret = 0;
        boolean isFinding = true;

        for (int i=0; isFinding && i<row; i++)
            for (int j=0; isFinding && j<col; j++)
                if (A[i][j] == 1) {
                    this.findIsland(A, row, col, i, j, q);
                    isFinding = false;
                }

        for (; !q.isEmpty(); ret++) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Integer curr = q.remove(),
                        currX = curr / 100,
                        currY = curr % 100;

                if (currX + 1 < row) {
                    if (A[currX+1][currY] == 0) {
                        q.add(this.normPos((currX + 1), currY));
                        A[currX + 1][currY] = 2;
                    } else if (A[currX+1][currY] == 1)
                        return ret;
                }

                if (currX - 1 > -1) {
                    if (A[currX-1][currY] == 0) {
                        q.add(this.normPos((currX-1), currY));
                        A[currX - 1][currY] = 2;
                    } else if (A[currX-1][currY] == 1)
                        return ret;
                }

                if (currY + 1 < col) {
                    if (A[currX][currY+1] == 0) {
                        q.add(this.normPos(currX, (currY+1)));
                        A[currX][currY+1] = 2;
                    } else if (A[currX][currY+1] == 1)
                        return ret;
                }

                if (currY - 1 > -1) {
                    if (A[currX][currY-1] == 0) {
                        q.add(this.normPos(currX, (currY-1)));
                        A[currX][currY-1] = 2;
                    } else if (A[currX][currY-1] == 1)
                        return ret;
                }
            }
        }

        return -1;
    }

    private void findIsland(int[][] arr, int row, int col, int x, int y, Queue<Integer> q) {
        if (x < 0 || y < 0 || x >= row || y >= col || arr[x][y] == 2 || arr[x][y] == 0)
            return;

        arr[x][y] = 2;
        q.add(this.normPos(x, y));
        this.findIsland(arr, row, col, x+1, y, q);
        this.findIsland(arr, row, col, x-1, y, q);
        this.findIsland(arr, row, col, x, y+1, q);
        this.findIsland(arr, row, col, x, y-1, q);
    }

    private int normPos(int x, int y) {
        return x * 100 + y;
    }
}