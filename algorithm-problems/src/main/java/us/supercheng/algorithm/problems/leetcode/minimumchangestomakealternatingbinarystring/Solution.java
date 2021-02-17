package us.supercheng.algorithm.problems.leetcode.minimumchangestomakealternatingbinarystring;

public class Solution {

    public int minOperations(String s) {
        int len = s.length();
        int countA = 0;
        int countB = 0;

        char[] a = new char[len];
        char[] b = new char[len];

        a[0] = '0';
        b[0] = '1';
        for (int i=1; i<len; i++) {
            a[i] = a[i - 1] == '0' ? '1' : '0';
            b[i] = b[i - 1] == '0' ? '1' : '0';
        }

        for (int i=0; i<len; i++) {
            char c = s.charAt(i);
            if (c != a[i])
                countA++;
            if (c != b[i])
                countB++;
        }

        return Math.min(countA, countB);
    }

}
