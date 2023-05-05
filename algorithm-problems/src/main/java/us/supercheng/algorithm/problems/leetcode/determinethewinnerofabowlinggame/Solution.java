package us.supercheng.algorithm.problems.leetcode.determinethewinnerofabowlinggame;

public class Solution {

    public int isWinner(int[] player1, int[] player2) {
        int p1 = score(player1);
        int p2 = score(player2);
        return p1 == p2 ? 0 : p1 < p2 ? 2 : 1;
    }

    private int score(int[] arr) {
        int ret = 0;

        for (int i = 0, len = arr.length; i < len; i++)
            ret += (i > 0 && arr[i - 1] == 10) || (i > 1 && arr[i - 2] == 10) ? arr[i] * 2 : arr[i];

        return ret;
    }

}
