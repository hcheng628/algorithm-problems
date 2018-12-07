package us.supercheng.algorithm.problems.triangle;

import java.util.List;

class Solution {

    public int minimumTotalSlow(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)
            return 0;
        else if(triangle.size() == 1)
            return triangle.get(0).get(0);

        Integer ret = null, sizeIndex = triangle.size()-1;

        for(int level=1;level<=sizeIndex;level++)
            for(int index=0;index<triangle.get(level).size();index++) {
                int curVal = triangle.get(level).get(index);
                if(index <= triangle.get(level-1).size()-1 && index -1 >= 0)
                    triangle.get(level).set(index, Math.min(curVal+triangle.get(level-1).get(index), curVal+triangle.get(level-1).get(index-1)));
                else if(index > triangle.get(level-1).size()-1 && index -1 >=0)
                    triangle.get(level).set(index, curVal + triangle.get(level-1).get(index-1));
                else
                    triangle.get(level).set(index, curVal + triangle.get(level-1).get(index));

                if(level == sizeIndex)
                    ret = ret == null ? triangle.get(level).get(index) : Math.min(ret, triangle.get(level).get(index));
            }
        return ret;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int [] dp = new int [triangle.size()+1];
        for(int i=triangle.size()-1;i>-1;i--)
            for(int j=0;j<triangle.get(i).size();j++)
                dp[j] =  triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
        return dp[0];
    }
}