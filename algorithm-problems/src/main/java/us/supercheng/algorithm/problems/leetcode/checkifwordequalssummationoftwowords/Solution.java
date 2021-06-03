package us.supercheng.algorithm.problems.leetcode.checkifwordequalssummationoftwowords;

public class Solution {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return this.getNum(firstWord) + this.getNum(secondWord) == this.getNum(targetWord);
    }

    private int getNum(String s) {
        int ret = 0;

        for (int i=s.length()-1, base=1; i>-1; i--, base *= 10)
            ret += (s.charAt(i) - 'a') * base;

        return ret;
    }

}
