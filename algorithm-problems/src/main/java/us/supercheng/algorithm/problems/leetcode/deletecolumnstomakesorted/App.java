package us.supercheng.algorithm.problems.leetcode.deletecolumnstomakesorted;

public class App {

    public int minDeletionSize(String[] A) {
        int retCount = 0;

        if(A == null || A.length == 0)
            return retCount;

        for(int i=0;i<A[0].length();i++)
            for(int j=0;j<A.length-1;j++)
                if(A[j].charAt(i) > A[j+1].charAt(i)) {
                    retCount++;
                    break;
                }

        return retCount;
    }
}
