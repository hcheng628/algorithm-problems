package us.supercheng.algorithm.problems.snakeandladders;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    private int size;
    private int end;
    private int[][] b;
    private Set<Integer> visited;
    private int ans = Integer.MAX_VALUE;

    public int snakesAndLadders(int[][] board) {
        this.b = board;
        this.visited = new HashSet<>();
        this.size = board.length;
        this.end = this.size * this.size;
        this.ans = this.end;
        this.BFS();
        return this.ans == this.end ? -1 : this.ans;
    }

    private void BFS() {
        int curr = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);

        for (int steps=1; !q.isEmpty(); steps++)
            for (int c=q.size(); c>0; c--) {
                curr = q.remove();
                for (int i=1; i<=6; i++) {
                    int next = curr + i;
                    if (next > this.end)
                        break;

                    int[] pos = this.getP(next);
                    if (this.b[pos[0]][pos[1]] != -1) {
                        this.visited.add(next);
                        next = this.b[pos[0]][pos[1]];
                    }

                    if (next == this.end) {
                        this.ans = steps;
                        return;
                    } else if (!this.visited.contains(next)) {
                        q.add(next);
                        this.visited.add(next);
                    }
                }
            }
    }

    private int[] getP(int p) {
        int row = this.size - p / this.size,
            col = p % this.size - 1;

        if (p % this.size != 0)
            row--;
        if (col < 0)
            col = this.size - 1;
        if ((this.size % 2 == 0 && row % 2 == 0) || (this.size % 2 != 0 && row % 2 != 0))
            col = Math.abs(this.size - col - 1);

        return new int[]{row, col};
    }
}