package us.supercheng.algorithm.problems.leetcode.sumofsquarenumbers;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int num = 1000000;
        PrintHelper.echoLn(new App().judgeSquareSum(num));
        PrintHelper.echoLn(new App().judgeSquareSum2(num));
    }

    public boolean judgeSquareSum(int c) {
        long lower=0, upper = c;
        while(upper >= lower) {
            long upperLimit = upper * upper;
            if(upperLimit > c) {
                upper--;
            } else  {
                long res = upperLimit + lower * lower;
                if(res == c)
                    return true;
                else if(res < c)
                    lower++;
                else
                    upper--;
            }
        }
        return false;
    }

    public boolean judgeSquareSum2(int c) {
        int lower=0, upper = (int)Math.sqrt(c);
        while(upper >= lower) {
            long res =  lower * lower + upper * upper;
            if(res == c)
                return true;
            else if(res < c)
                lower++;
            else
                upper--;
        }
        return false;
    }

    public boolean judgeSquareSum3(int c) {
        double test = Math.sqrt(c);
        int lower=0, upper = (int) test;
        if(test - Math.floor(test) == 0)
            return true;
        while(upper >= lower) {
            long res =  lower * lower + upper * upper;
            if(res == c)
                return true;
            else if(res < c)
                lower++;
            else
                upper--;
        }
        return false;
    }
}