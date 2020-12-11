package us.supercheng.algorithm.problems.leetcode.multiplystrings;

public class App {

    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null)
            return "0";
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        if(num1.equals("1"))
            return num2;
        if(num2.equals("1"))
            return num1;

        int [] A = new int[num1.length()];
        int [] B = new int[num2.length()];
        int [] res = new int[A.length + B.length];

        for(int i=0;i<num1.length();i++)
            A[i] = num1.charAt(i) - '0';

        for(int i=0;i<num2.length();i++)
            B[i] = num2.charAt(i) - '0';

        int index = 0, overflow = 0, count = 0;
        for(int i=A.length-1;i>=0;i--, count++) {
            index = res.length-1 - count;
            for(int j=B.length-1;j>=0;j--) {
                int temp = A[i] * B[j];
                res[index] += ((temp % 10));
                overflow = temp / 10;
                if(res[index] > 9) {
                    overflow += (res[index] / 10);
                    res[index] = res[index] % 10;
                }
                res[index-1] += overflow;
                index--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<res.length;i++)
            if(i!=0 || res[i] != 0)
                sb.append(res[i]);
        return sb.toString();
    }

}