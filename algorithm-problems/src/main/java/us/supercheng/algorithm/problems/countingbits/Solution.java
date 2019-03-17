package us.supercheng.algorithm.problems.countingbits;

public class Solution {
    public int[] countBits(int num) {
        int [] ret = new int [num + 1];
        for (int i=0;i<ret.length;i++)
            for (char each : Integer.toBinaryString(i).toCharArray())
                if (each == '1')
                    ret[i]++;
        return ret;
    }
}