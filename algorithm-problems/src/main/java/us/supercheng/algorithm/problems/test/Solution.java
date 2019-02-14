package us.supercheng.algorithm.problems.test;

import us.supercheng.algorithm.common.helper.PrintHelper;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        int [][] nums = {{1,1,0},{1,1,0},{0,0,1}};

        Solution solution = new Solution();
        int res = solution.numSquares(12);

    }

    public int numSquares(int n) {

        List<Integer> list = new ArrayList<>();
        int i=1;
        for (;true;i++) {
            int res = i*i;
            if (res > n) {
                i--;
                break;
            } else if (res == n) {
                return 1;
            }

            list.add(res);
        }

        //PrintHelper.echoLn("i === " + i);

        List<Integer> ret = new ArrayList<>();

        this.helper(list, ret, 0, n);
        return 0;
    }

    private void helper(List<Integer> list, List<Integer> ret, int i, int res) {
        if(res - list.get(i) < 0)
            return;
        else if (res - list.get(i) == 0) {
            ret.add(list.get(i));
            return;
        }

        for (int j=0;j<list.size();j++) {

        }


    }
}