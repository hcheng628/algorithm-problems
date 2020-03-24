package us.supercheng.algorithm.problems.findnuniqueintegerssumuptozero;

public class Solution {

    public int[] sumZero(int n) {
        int[] ret = new int[n];

        for (int i=0, num=1, half=n/2;i<half;i++,num++) {
            ret[i] = num;
            ret[i+half] = -num;
        }

        return ret;
    }
}
