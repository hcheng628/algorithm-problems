package us.supercheng.algorithm.problems.excelsheetcolumnnumber;

public class Solution {

    public int titleToNumber(String s) {
        int ret = 0;

        for (int idx=s.length()-1, base=0;idx>-1;idx--)
            ret += (s.charAt(idx) - 'A' + 1) * Math.pow(26, base++);

        return ret;
    }
}