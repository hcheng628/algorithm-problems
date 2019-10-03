package us.supercheng.algorithm.problems.twokeyskeyboard;

class Solution {

    int min = 2000;

    public int minSteps(int n) {
        this.helper(n, 1, 0, 0, true);
        return this.min;
    }

    private void helper(int n, long curr, long clipboard, int count, boolean isCopy) {
        if (curr > n)
            return;
        else if (curr == n) {
            this.min = Math.min(this.min, count);
            return;
        }

        if (isCopy)
            this.helper(n, curr, curr, count+1, false);
        else {
            this.helper(n, curr+clipboard, clipboard, count+1, false);
            this.helper(n, curr+clipboard, clipboard, count+1, true);
        }
    }
}