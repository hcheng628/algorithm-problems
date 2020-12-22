package us.supercheng.algorithm.problems.algo.spiraltraverse;

import java.util.*;

public class Program {

    public static List<Integer> spiralTraverse_Solution1(int[][] array) {
        int[][] dir = new int [][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int len = array.length,
            wid = array[0].length,
            x = 0,
            y = 0;

        boolean[][] visited = new boolean[len][wid];
        List<Integer> ret = new ArrayList<>();
        ret.add(array[x][y]);
        visited[0][0] = true;

        while (ret.size() != len * wid)
            for (int i=0; i<4 && ret.size() != len * wid; i++)
                for (int j=0, end =i % 2 == 0 ? wid : len; j<end && ret.size() != len * wid; j++) {
                    x += dir[i][0];
                    y += dir[i][1];

                    if (x < 0 || y < 0 || x >= len || y >= wid || visited[x][y]) {
                        if (i == 0) {
                            x++;
                            y--;
                        } else if (i == 1) {
                            x--;
                            y--;
                        } else if (i == 2) {
                            x--;
                            y++;
                        } else {
                            x++;
                            y++;
                        }
                        visited[x][y] = true;
                        ret.add(array[x][y]);
                        break;
                    }
                    visited[x][y] = true;
                    ret.add(array[x][y]);
                }

        return ret;
    }

    public static List<Integer> spiralTraverse_Solution2(int[][] array) {
        List<Integer> ret = new ArrayList<Integer>();
        int len = array.length,
            wid = array[0].length,
            startRow = 0,
            endRow = len - 1,
            startCol = 0,
            endCol = wid - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int i=startCol; i<=endCol; i++)
                ret.add(array[startRow][i]);

            for (int i=startRow+1; i<=endRow; i++)
                ret.add(array[i][endCol]);

            for (int i=endCol-1; endRow != startRow && i>= startCol; i--)
                ret.add(array[endRow][i]);

            for (int i=endRow-1; startCol != endCol && i>startRow; i--)
                ret.add(array[i][startCol]);

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

        return ret;
    }

    public static List<Integer> spiralTraverse_Solution3(int[][] array) {
        return helper(array, new ArrayList<Integer>(), 0, 0, array.length-1, array[0].length-1);
    }

    private static List<Integer> helper(int[][] arr, List<Integer> ret, int startRow, int startCol, int endRow, int endCol) {
        if (startRow > endRow || startCol > endCol)
            return ret;

        for (int i=startCol; i<=endCol; i++)
            ret.add(arr[startRow][i]);

        for (int i=startRow+1; i<=endRow; i++)
            ret.add(arr[i][endCol]);

        for (int i=endCol-1; startRow != endRow && i>=startCol; i--)
            ret.add(arr[endRow][i]);

        for (int i=endRow-1; startCol != endCol && i>startRow; i--)
            ret.add(arr[i][startCol]);

        return helper(arr, ret, startRow + 1, startCol + 1, endRow - 1, endCol - 1);
    }
}

