package us.supercheng.algorithm.problems.leetcode.projectionareaof3dshapes;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int[][] grid = {{2,2,2},{2,1,2},{2,2,2}};
        PrintHelper.echoLn("Res: " + new App().projectionArea(grid));
    }

    public int projectionArea(int[][] grid) {
        return this.calXY(grid) + this.calYZ(grid) + this.calZX(grid);
    }

    public int calXY(int[][] grid) {
        int ret = 0;
        for(int i=0;i<grid.length;i++) {
            int maxRow = 0;
            for(int j=0;j<grid[i].length;j++)
                if(grid[i][j]>maxRow)
                    maxRow = grid[i][j];
            ret += maxRow;
        }
        return ret;
    }

    public int calYZ(int[][] grid) {
        int ret = 0;
        for(int i=0;i<grid[0].length;i++) {
            int maxRow = 0;
            for(int j=0;j<grid.length;j++)
                if(grid[j][i] > maxRow)
                    maxRow = grid[j][i];
            ret += maxRow;
        }
        return ret;
    }

    public int calZX(int[][] grid) {
        int ret = 0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[i].length;j++)
                if(grid[i][j]>0)
                    ret++;
        return ret;
    }
}