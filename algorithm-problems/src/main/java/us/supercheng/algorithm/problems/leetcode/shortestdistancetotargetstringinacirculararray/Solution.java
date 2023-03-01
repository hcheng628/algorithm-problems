package us.supercheng.algorithm.problems.leetcode.shortestdistancetotargetstringinacirculararray;

class Solution {

    public int closetTarget(String[] words, String target, int startIndex) {
        int fSteps = 0;
        int bSteps = 0;
        int len = words.length;

        for (int fIdx = startIndex, bIdx = startIndex; (fSteps < len && fIdx != -1) || (bSteps < len && bIdx != -1); ) {
            if (fIdx != -1)
                if (words[fIdx].equals(target))
                    fIdx = -1;
                else {
                    fIdx = this.next(len, fIdx, true);
                    fSteps++;
                }

            if (bIdx != -1)
                if (words[bIdx].equals(target))
                    bIdx = -1;
                else {
                    bIdx = this.next(len, bIdx, false);
                    bSteps++;
                }
        }

        return Math.min(fSteps, bSteps) == len ? -1 : Math.min(fSteps, bSteps);
    }

    private int next(int len, int idx, boolean forward) {
        return forward ? idx + 1 < len ? idx + 1 : 0 : idx - 1 > -1 ? idx - 1 : len - 1;
    }

}
