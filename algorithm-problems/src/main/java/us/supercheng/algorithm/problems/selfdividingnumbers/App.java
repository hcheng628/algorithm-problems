package us.supercheng.algorithm.problems.selfdividingnumbers;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class App {

    public static void main(String[] args) {
        int left = 12, right = 33;
        for(int each : new App().selfDividingNumbers(left, right))
            PrintHelper.echo(each + " ");

        PrintHelper.echoLn("");

        for(int each : new App().selfDividingNumbers1(left, right))
            PrintHelper.echo(each + " ");
    }

    public List<Integer> selfDividingNumbers2(int left, int right) {
        List<Integer> ret = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=left; i<=right; i++) {
            char [] digits = (i + "").toCharArray();
            boolean isSelfDiv = true, hasZero = false;
            if(!set.isEmpty())
                set.clear();
            for(char digit : digits) {
                if(digit == '0') {
                    hasZero = true;
                    break;
                }
                set.add(((int)digit) - 48);
            }

            if(hasZero)
                continue;

            for (int each : set) {
                if(i%each != 0) {
                    isSelfDiv = false;
                    break;
                }
            }
            if(isSelfDiv)
                ret.add(i);
        }
        return ret;
    }

    public List<Integer> selfDividingNumbers1(int left, int right) {
        List<Integer> ret = new ArrayList<>();
        for(int eachNum=left;eachNum<=right;eachNum++)
            if(this.add(eachNum))
                ret.add(eachNum);
        return ret;
    }

    private boolean add(int val) {
        char[] digits = (val + "").toCharArray();
        for(char digit : digits)
            if(digit == '0' || val % (digit - '0') != 0)
                return false;
        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ret = new ArrayList<>();
        for(int eachNum=left;eachNum<=right;eachNum++) {
            int digits = eachNum;
            for(;digits>0;digits /=10) {
                int currDigit = digits % 10;
                if(currDigit == 0 || eachNum % currDigit != 0)
                    break;
            }
            if(digits == 0)
                ret.add(eachNum);
        }
        return ret;
    }
}