package us.supercheng.algorithm.problems.leetcode.reformatphonenumber;

public class Solution {

    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        int currLen = 0;

        for (char n : number.toCharArray())
            if (Character.isDigit(n)) {
                sb.append(n);
                currLen++;
                if (currLen == 3) {
                    sb.append('-');
                    currLen = 0;
                }
            }


        if (sb.charAt(sb.length() - 1) == '-')
            sb.setLength(sb.length() - 1);

        if (currLen == 1) {
            int idx = sb.length() - 3;
            char c = sb.charAt(idx);
            sb.deleteCharAt(idx);
            sb.insert(sb.length() - 1, c);
        }

        return sb.toString();
    }
}