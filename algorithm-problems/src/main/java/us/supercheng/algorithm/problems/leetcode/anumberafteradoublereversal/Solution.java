package us.supercheng.algorithm.problems.leetcode.anumberafteradoublereversal;

class Solution {

    public boolean isSameAfterReversals(int num) {
        if (num == 0)
            return true;
        String s = String.valueOf(num);
        return s.charAt(s.length() - 1) != '0';
    }

}
