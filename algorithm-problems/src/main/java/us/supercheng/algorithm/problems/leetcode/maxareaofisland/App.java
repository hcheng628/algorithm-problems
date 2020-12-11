package us.supercheng.algorithm.problems.leetcode.maxareaofisland;

import java.util.*;

public class App {

    private int max = 0;

    public int maxAreaOfIsland4(int[][] grid) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[i].length;j++)
                if(grid[i][j] == 1 && !set.contains(i+":" + j))
                    helper4(grid, i, j, set);
        return max;
    }

    private void helper4(int[][] grid, int i, int j, Set<String> set) {
        Stack<String> stack = new Stack<>();
        stack.push(i+":"+j);
        set.add(i+":"+j);

        int count = 0;
        while(!stack.isEmpty()) {
            String each = stack.pop();
            int row = Integer.parseInt(each.substring(0, each.indexOf(":")));
            int col = Integer.parseInt(each.substring(each.indexOf(":")+1, each.length()));
            count++;

            if(row+1 <= grid.length -1 && grid[row+1][col] == 1 && !set.contains((row+1) + ":" + col)) {
                stack.push((row+1) + ":" + col);
                set.add((row+1) + ":" + col);
            }

            if(row -1 >= 0 && grid[row-1][col] == 1 && !set.contains((row-1) + ":" + col)) {
                stack.push((row-1) + ":" + col);
                set.add((row-1) + ":" + col);
            }

            if(col+1 <= grid[0].length -1 && grid[row][col+1] == 1 && !set.contains(row + ":" + (col+1))) {
                stack.push(row + ":" + (col+1));
                set.add(row + ":" + (col+1));
            }

            if(col-1 >= 0 && grid[row][col-1] == 1 && !set.contains(row + ":" + (col-1))) {
                stack.push(row + ":" + (col-1));
                set.add(row + ":" + (col-1));
            }
        }
        if(count > max)
            max = count;
    }

    class Pos{
        public int row;
        public int col;

        public Pos(int r, int c) {
            row = r;
            col = c;
        }
    }

    public int maxAreaOfIsland3(int[][] grid) {
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[i].length;j++)
                if(grid[i][j] == 1)
                    helper3(grid, i, j);
        return max;
    }

    private void helper3(int[][] grid, int i, int j) {
        Stack<Pos> stack = new Stack<>();
        stack.push(new Pos(i, j));
        grid[i][j] = 0;
        int count = 0;
        while(!stack.isEmpty()) {
            Pos eachPos = stack.pop();
            count++;
            if(eachPos.row+1 <= grid.length -1 && grid[eachPos.row+1][eachPos.col] == 1) {
                stack.push(new Pos(eachPos.row+1, eachPos.col));
                grid[eachPos.row+1][eachPos.col] = 0;
            }

            if(eachPos.row -1 >= 0 && grid[eachPos.row-1][eachPos.col] == 1) {
                stack.push(new Pos(eachPos.row-1, eachPos.col));
                grid[eachPos.row-1][eachPos.col] = 0;
            }

            if(eachPos.col+1 <= grid[0].length -1 && grid[eachPos.row][eachPos.col+1] == 1) {
                stack.push(new Pos(eachPos.row, eachPos.col+1));
                grid[eachPos.row][eachPos.col+1] = 0;
            }

            if(eachPos.col-1 >= 0 && grid[eachPos.row][eachPos.col-1] == 1) {
                stack.push(new Pos(eachPos.row, eachPos.col-1));
                grid[eachPos.row][eachPos.col-1] = 0;
            }
        }
        if(count > max)
            max = count;
    }

    public int maxAreaOfIsland2(int[][] grid) {
        List<Integer> rowList = new ArrayList<>(), colList = new ArrayList<>();
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[i].length;j++)
                if(grid[i][j] == 1)
                    helper2(grid, i, j, rowList, colList);
        return max;
    }

    private void helper2(int[][] grid, int i, int j, List<Integer> rowList, List<Integer> colList) {
        rowList.add(i);
        colList.add(j);
        grid[i][j] = 0;
        int count = 0;
        while(rowList.size() >0) {
            int row = rowList.get(0);
            int col = colList.get(0);
            rowList.remove(0);
            colList.remove(0);
            count++;

            if(row+1 <= grid.length -1 && grid[row+1][col] == 1) {
                rowList.add(row+1);
                colList.add(col);
                grid[row+1][col] = 0;
            }

            if(row -1 >= 0 && grid[row-1][col] == 1) {
                rowList.add(row-1);
                colList.add(col);
                grid[row-1][col] = 0;
            }

            if(col+1 <= grid[0].length -1 && grid[row][col+1] == 1) {
                rowList.add(row);
                colList.add(col+1);
                grid[row][col+1] = 0;
            }

            if(col-1 >= 0 && grid[row][col-1] == 1) {
                rowList.add(row);
                colList.add(col-1);
                grid[row][col-1] = 0;
            }
        }
        if(count > max)
            max = count;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int ret = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == 1) {
                    int temp = helper(grid, i, j);
                    if(temp > ret)
                        ret = temp;
                }
            }
        }
        return ret;
    }

    private int helper(int[][] grid, int row, int col) {
        int ret = 1;

        if(row < 0 || row > grid.length -1 || col < 0 || col > grid[0].length -1 || grid[row][col] == 0)
            return 0;

        grid[row][col] = 0;
        ret += helper(grid, row+1, col);
        ret += helper(grid, row-1, col);
        ret += helper(grid, row, col+1);
        ret += helper(grid, row, col-1);
        return ret;
    }
}