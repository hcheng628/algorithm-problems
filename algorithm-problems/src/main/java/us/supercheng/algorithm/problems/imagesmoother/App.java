package us.supercheng.algorithm.problems.imagesmoother;

public class App {

    public int[][] imageSmoother(int[][] M) {
        if(M == null || M.length < 1)
            return null;
        int [][] ret = new int [M.length][M[0].length];
        for(int i=0;i<M.length;i++) {
            for(int j=0;j<M[i].length;j++) {
                if(i == 0) {
                    if(j == 0) {
                        if(j+1 <= M[i].length -1 && i+1 <=M.length - 1)
                            ret[i][j] = (int) Math.floor((M[i][j] + M[i+1][j] + M[i][j+1] + M[i+1][j+1]) / 4);
                        else if (j+1 > M[i].length -1 && i+1 <=M.length - 1)
                            ret[i][j] = (int) Math.floor((M[i][j] + M[i+1][j]) / 2);
                        else if (j+1 <= M[i].length -1 && i+1 > M.length - 1 )
                            ret[i][j] = (int) Math.floor((M[i][j] + M[i][j+1]) / 2);
                        else
                            ret[i][j] = M[i][j];
                    } else if (j == M[i].length -1) {
                        if(i + 1 <= M.length -1)
                            ret[i][j] = (int) Math.floor((M[i][j] + M[i][j-1] + M[i+1][j-1] + M[i+1][j])/4);
                        else
                            ret[i][j] = (int) Math.floor((M[i][j] + M[i][j-1])/2);
                    } else {
                        if(i+1 <= M.length - 1)
                            ret[i][j] = (int) Math.floor((M[i][j] + M[i][j-1] + M[i][j+1] + M[i+1][j-1] + M[i+1][j] + M[i+1][j+1])/6);
                        else
                            ret[i][j] = (int) Math.floor((M[i][j] + M[i][j-1] + M[i][j+1])/3);
                    }
                } else if (i == M.length -1) {
                    if(j == 0) {
                        if(j+1 <= M[i].length -1)
                            ret[i][j] = (int) Math.floor((M[i][j] + M[i-1][j] + M[i][j+1] + M[i-1][j+1])/4);
                        else
                            ret[i][j] = (int) Math.floor((M[i][j] + M[i-1][j])/2);
                    } else if (j == M[i].length -1)
                        ret[i][j] = (int) Math.floor((M[i][j] + M[i-1][j] + M[i][j-1] + M[i-1][j-1])/4);
                    else
                        ret[i][j] = (int) Math.floor((M[i][j] + M[i][j-1] + M[i][j+1] + M[i-1][j-1] + M[i-1][j] + M[i-1][j+1])/6);
                } else {
                    if(j == 0) {
                        if(j+1 <= M[i].length -1)
                            ret[i][j] = (int) Math.floor((M[i][j] + M[i+1][j] + M[i-1][j] + M[i][j+1] + M[i-1][j+1] + M[i+1][j+1])/6);
                        else
                            ret[i][j] = (int) Math.floor((M[i][j] + M[i+1][j] + M[i-1][j])/3);
                    } else if (j == M[i].length -1)
                        ret[i][j] = (int) Math.floor((M[i][j] + M[i+1][j] + M[i-1][j] + M[i][j-1] + M[i+1][j-1] + M[i-1][j-1])/6);
                    else
                        ret[i][j] = (int) Math.floor((M[i][j-1] + M[i][j] + M[i][j+1] + M[i-1][j-1] + M[i-1][j] + M[i-1][j+1] + M[i+1][j-1] + M[i+1][j] + M[i+1][j+1])/9);
                }
            }
        }
        return ret;
    }

    public int[][] imageSmoother2(int[][] M) {
        int[][] ret = new int [M.length][M[0].length];
        for(int i=0;i<M.length; i++)
            for(int j=0;j<M[i].length;j++)
                ret[i][j] = helper(M, i, j);
        return ret;
    }

    private int helper(int[][] M, int i, int j) {
        int sum = 0, count = 0;
        for(int row=-1;row<=1;row++) {
            for(int col=-1;col<=1;col++) {
                if(i+row <= M.length - 1 && i+row >= 0 && j+col <=M[0].length -1 && j+col >=0) {
                    count++;
                    sum += M[i+row][j+col];
                }
            }
        }
        return sum/count;
    }
}
