package us.supercheng.algorithm.problems.differentwaystoaddparentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.diffWaysToCompute("2*3-4*5");
    }


    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new ArrayList();

        for (int i=0;i<input.length();i++) {
            char each = input.charAt(i);
            if(!Character.isDigit(each)) {
                List<Integer> left = this.diffWaysToCompute(input.substring(0,i)),
                              right = this.diffWaysToCompute(input.substring(i+1, input.length()));
                for (int l : left)
                    for (int r : right) {
                        if(each == '+')
                            ret.add(l+r);
                        else if (each == '-')
                            ret.add(l-r);
                        else
                            ret.add(l*r);
                    }
            }
        }

        if (ret.size() == 0)
            ret.add(Integer.parseInt(input));
        return ret;
    }
}