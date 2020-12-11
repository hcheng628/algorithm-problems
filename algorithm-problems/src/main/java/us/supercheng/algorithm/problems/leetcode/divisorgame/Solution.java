package us.supercheng.algorithm.problems.leetcode.divisorgame;

class Solution {
    public boolean divisorGame(int N) {
        return this.play(N, true);
    }

    private boolean play(int N, boolean isAlice) {
        for (int curr=1;curr<=1000 && curr < N; curr++)
            if (N % curr == 0)
                return this.play(N-curr, !isAlice);
        return !isAlice;
    }
}