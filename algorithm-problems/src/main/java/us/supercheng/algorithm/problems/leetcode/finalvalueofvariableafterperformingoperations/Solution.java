package us.supercheng.algorithm.problems.leetcode.finalvalueofvariableafterperformingoperations;

public class Solution {

    public int finalValueAfterOperations(String[] operations) {
        int ret = 0;

        for (String o : operations)
            ret += o.charAt(1) == '+' ? 1 : -1;

        return ret;
    }

}
