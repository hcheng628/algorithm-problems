package us.supercheng.algorithm.problems.leetcode.fractiontorecurringdecimal;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "";
        s = solution.fractionToDecimal(1, 2);
        PrintHelper.echoLn(s);
        s = solution.fractionToDecimal(2, 1);
        PrintHelper.echoLn(s);
        s = solution.fractionToDecimal(2, 3);
        PrintHelper.echoLn(s);
        s = solution.fractionToDecimal(4, 333);
        PrintHelper.echoLn(s);
        s = solution.fractionToDecimal(1, 333);
        PrintHelper.echoLn(s);
        s = solution.fractionToDecimal(-1, -2147483648);
        PrintHelper.echoLn(s);
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return "0";
        StringBuilder sb = new StringBuilder((numerator > 0 && denominator > 0) || (numerator < 0 && denominator < 0) ? "" : "-");
        long num = Math.abs((long)numerator), den = Math.abs((long)denominator);
        sb.append(num / den);
        num %= den;
        if(num == 0)
            return sb.toString();

        sb.append(".");
        Map<Long, Integer> map = new HashMap();
        map.put(num, sb.length());

        while (num != 0) {
            num *= 10;
            sb.append(num / den);
            num %= den;
            if(map.containsKey(num)) {
                sb.insert(map.get(num), "(");
                sb.append(")");
                return sb.toString();
            }
            else
                map.put(num, sb.length());
        }
        return sb.toString();
    }
}