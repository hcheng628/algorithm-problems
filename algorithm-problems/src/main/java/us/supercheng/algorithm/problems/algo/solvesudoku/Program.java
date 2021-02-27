package us.supercheng.algorithm.problems.algo.solvesudoku;

import java.util.*;

class Program {

    public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        this.helper(board, 0, 0);
        return board;
    }

    private boolean helper(ArrayList<ArrayList<Integer>> board, int x, int y) {
        if (x > 8 || y > 8)
            return true;

        int curr = board.get(x).get(y);
        int newX = x;
        int newY = y + 1;
        if (newY > 8) {
            newY = 0;
            newX++;
        }

        if (curr != 0)
            return this.helper(board, newX, newY);

        List<Integer> nums = this.getNums(x, y, board);
        if (nums.isEmpty())
            return false;

        for (int n : nums) {
            board.get(x).set(y, n);
            if (!this.helper(board, newX, newY))
                board.get(x).set(y, 0);
            else
                return true;
        }

        return false;
    }

    private List<Integer> getNums(int r, int c, ArrayList<ArrayList<Integer>> board) {
        Set<Integer> set = new HashSet<>(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9}));

        for (int i=0, baseX = r / 3 * 3, baseY = c / 3 * 3; i<3; i++)
            for (int j=0; j<3; j++)
                set.remove(board.get(i + baseX).get(j + baseY));

        for (int i=0; i<9; i++)
            set.remove(board.get(r).get(i));

        for (int i=0; i<9; i++)
            set.remove(board.get(i).get(c));

        return new ArrayList<>(set);
    }
}
