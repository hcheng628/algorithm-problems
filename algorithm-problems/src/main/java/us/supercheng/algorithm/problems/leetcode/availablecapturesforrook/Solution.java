package us.supercheng.algorithm.problems.leetcode.availablecapturesforrook;

class Solution {

    final int [][] DIR = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int numRookCaptures(char[][] board) {
        int rX = -1, rY = -1, ret = 0;

        for (int i=0;i<8&&rX==-1;i++)
            for (int j=0;j<8;j++)
                if (board[i][j] == 'R') {
                    rX = i;
                    rY = j;
                    break;
                }

        for (int eachDir=0; eachDir<this.DIR.length; eachDir++) {
            int i=rX + this.DIR[eachDir][0],
                    j=rY + this.DIR[eachDir][1];
            while (i<8 && i>-1 && j<8 && j>-1) {
                if (board[i][j] == 'B')
                    break;
                else if (board[i][j] == 'p') {
                    ret++;
                    break;
                }
                i += this.DIR[eachDir][0];
                j += this.DIR[eachDir][1];
            }
        }
        return ret;
    }
}