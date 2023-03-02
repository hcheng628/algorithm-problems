package us.supercheng.algorithm.problems.leetcode.shortestdistancetotargetstringinacirculararray;

class Solution {

    public int closetTarget(String[] words, String target, int startIndex) {
        int ret = 0;
        int len = words.length;

        for (int fIdx = startIndex, bIdx = startIndex; ret < len; ret++) {
            if (words[fIdx].equals(target) || words[bIdx].equals(target))
                return ret;
            fIdx++;
            if (fIdx == len)
                fIdx = 0;
            bIdx--;
            if (bIdx == -1)
                bIdx = len - 1;
        }

        return ret == len ? -1 : ret;
    }

}
