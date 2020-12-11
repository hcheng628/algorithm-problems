package us.supercheng.algorithm.problems.leetcode.graycode;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        new App().grayCode(3);
    }

    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        int res = (int) Math.pow(2, n);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<res;i++)
            ret.add(Integer.parseInt(this.calGrayCode(Integer.toBinaryString(i).toCharArray(), sb), 2));
        return ret;
    }

    private String calGrayCode(char[] chars, StringBuilder sb) {
        if(sb.length() != 0)
            sb.setLength(0);
        for(int i=0;i<chars.length;i++) {
            if(i==0)
                sb.append(chars[i]);
            else {
                if((chars[i-1] == '1' && chars[i] == '1') || (chars[i-1] == '0' && chars[i] == '0'))
                    sb.append('0');
                else
                    sb.append('1');
            }
        }
        return sb.toString();
    }
}