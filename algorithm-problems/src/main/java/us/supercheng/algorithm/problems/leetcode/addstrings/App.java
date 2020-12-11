package us.supercheng.algorithm.problems.leetcode.addstrings;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        App app = new App();
        int a = 13628;
        int b = 67162809;

        PrintHelper.echoLn("Calculate " + a + " + " + b + " = ?");
        long start = System.nanoTime();
        PrintHelper.echoLn("String Cal 1: " + app.addStrings(a+"", b+""));
        long end = System.nanoTime();
        PrintHelper.echoLn("Time: " + (end - start) + "\n");

        start = System.nanoTime();
        PrintHelper.echoLn("String Cal 2: " + app.addStrings2(a+"", b+""));
        end = System.nanoTime();
        PrintHelper.echoLn("Time: " + (end - start) + "\n");

        start = System.nanoTime();
        PrintHelper.echoLn("Math-- Cal >> " + (a + b));
        end = System.nanoTime();
        PrintHelper.echoLn("Time: " + (end - start));
    }


    public String addStrings(String num1, String num2) {
        char [] arr1 = num1.toCharArray();
        char [] arr2 = num2.toCharArray();

        List<Integer> list = new ArrayList<>();
        int index1 = arr1.length -1;
        int index2 = arr2.length -1;
        int carry = 0;
        int sum;
        while(index1 >= 0 && index2 >= 0) {
            int res = (arr1[index1] - 48) + (arr2[index2] - 48) + carry;
            carry = res / 10;
            sum = res % 10;
            list.add(sum);
            index1--;
            index2--;
        }

        while(index1 >=0) {
            int res = (arr1[index1] - 48) + carry;
            carry = res / 10;
            sum = res % 10;
            list.add(sum);
            index1--;
        }

        while(index2 >=0) {
            int res = (arr2[index2] - 48) + carry;
            carry = res / 10;
            sum = res % 10;
            list.add(sum);
            index2--;
        }

        if(carry != 0)
            list.add(carry);

        String ss = "";
        for(int i=list.size()-1;i>=0;i--)
            ss += list.get(i);
        return ss;
    }

    public String addStrings2(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        char [] arr1 = num1.toCharArray();
        char [] arr2 = num2.toCharArray();
        int index1 = arr1.length -1;
        int index2 = arr2.length -1;
        int carry = 0;
        int sum;
        while(index1 >= 0 && index2 >= 0) {
            int res = (arr1[index1] - 48) + (arr2[index2] - 48) + carry;
            carry = res / 10;
            sum = res % 10;
            sb.append(sum);
            index1--;
            index2--;
        }
        while(index1 >=0) {
            int res = (arr1[index1] - 48) + carry;
            carry = res / 10;
            sum = res % 10;
            sb.append(sum);
            index1--;
        }
        while(index2 >=0) {
            int res = (arr2[index2] - 48) + carry;
            carry = res / 10;
            sum = res % 10;
            sb.append(sum);
            index2--;
        }
        if(carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}