package us.supercheng.algorithm.problems.leetcode.zigzagconversion;

import us.supercheng.algorithm.common.helper.PrintHelper;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        PrintHelper.echoLn(new App().convert(s, numRows));
    }

    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        char[] chars = s.toCharArray();
        List<char[]> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int count = numRows, index = 0, eachCount = 0;

        for(int len=chars.length;len >0;len--,count = numRows) {
            char[] arr = new char[numRows];
            while(count>0 &&index<chars.length) {
                if(eachCount == 0)
                    arr[numRows - count--] = chars[index++];
                else {
                    arr[numRows-eachCount-1] = chars[index++];
                    break;
                }
            }
            list.add(arr);
            eachCount++;
            if(eachCount == numRows -1)
                eachCount = 0;
        }

        for(int out=0;out<numRows;out++)
            for(int i=0;i<list.size();i++)
                if(list.get(i)[out] != '\u0000')
                    sb.append(list.get(i)[out]);
        return sb.toString();
    }
}