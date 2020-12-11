package us.supercheng.algorithm.problems.leetcode.addbinary;

public class App {
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();

            if(a.length() > b.length())
                b = this.doPrefixZeros(a.length()-b.length(), sb) + b;
            else if (a.length() < b.length())
                a = this.doPrefixZeros(b.length()-a.length(), sb) + a;

            char[] charsA = a.toCharArray(), charsB = b.toCharArray();
            boolean overflow = false;

            for(int i=charsA.length-1;i>-1;i--) {
                if(!overflow && charsA[i] == '0' && charsB[i] == '0')
                    sb.append(0);
                else if (overflow && charsA[i] == '0' && charsB[i] == '0') {
                    sb.append(1);
                    overflow = false;
                } else if (!overflow && charsA[i] == '0' && charsB[i] == '1')
                    sb.append(1);
                else if (overflow && charsA[i] == '0' && charsB[i] == '1')
                    sb.append(0);
                else if (!overflow && charsA[i] == '1' && charsB[i] == '0')
                    sb.append(1);
                else if (overflow && charsA[i] == '1' && charsB[i] == '0')
                    sb.append(0);
                else if (!overflow && charsA[i] == '1' && charsB[i] == '1') {
                    sb.append(0);
                    overflow = true;
                } else
                    sb.append(1);
            }
            if(overflow)
                sb.append(1);
            return sb.reverse().toString();
        }

        private String doPrefixZeros(int count, StringBuilder sb) {
            for(int i=0;i<count;i++)
                sb.append(0);
            String ret = sb.toString();
            sb.setLength(0);
            return ret;
        }
    }
}
