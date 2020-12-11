package us.supercheng.algorithm.problems.leetcode.largesttimeforgivendigits;

class Solution {
    public String largestTimeFromDigits(int[] A) {
        String ret = null;
        for(int a=0;a<4;a++)
            for(int b=0;b<4;b++)
                for(int c=0;c<4;c++)
                    for(int d=0;d<4;d++) {
                        if(a == b || a == c || a == d || b == c || b == d || c == d)
                            continue;
                        String temp = ""+A[a]+A[b]+A[c]+A[d];
                        if(temp.compareTo("2359") <= 0 && temp.substring(2,4).compareTo("60")<0) {
                            if(ret == null)
                                ret = temp;
                            else if(temp.compareTo(ret)>0)
                                ret = temp;
                        }
                    }
        return ret == null ? "" : ret.substring(0,2) + ":" + ret.substring(2,4);
    }
}