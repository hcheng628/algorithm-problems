package us.supercheng.algorithm.problems.leetcode.checkifallasappearsbeforeallbs;

class Solution {

    public boolean checkString(String s) {
        if (s == null)
            return false;

        int firstB = s.indexOf('b');
        return firstB < 0 || s.lastIndexOf('a') < firstB;
    }

}
