package us.supercheng.algorithm.problems.nextgreaterelementiii;

import java.util.Arrays;

class Solution {

    public int nextGreaterElement(int n) {
        char[] chars = Integer.toString(n).toCharArray();
        int ret = -1,
                idx = 0;
        this.helper(chars);
        //this.echo(new String(chars));
        long res = Long.parseLong(new String(chars));
        if ( res > Integer.MAX_VALUE || res == n)
            return -1;
        return (int) res;
    }


    private void helper(char[] chars) {
        int idxL = -1,
                idxR = -1,
                len = chars.length;

        for (int start=0;start<len;start++)
            for (int end=len-1;end>start;end--)
                if (chars[end] - chars[start] > 0) {
                    idxL = start;
                    idxR = end;
                    break;
                }

        if (idxL == -1)
            return;

        while(idxR > 1 && chars[idxR] == chars[idxR-1])
            idxR--;

        char temp = chars[idxL];
        chars[idxL] = chars[idxR];
        chars[idxR] = temp;

        if (len-idxL-1 > 0) {
            char[] arr = new char[len-idxL-1];
            int tempIdx = idxL + 1;
            for (int i=0;i<arr.length;i++)
                arr[i] = chars[tempIdx++];

            Arrays.sort(arr);
            for (int i=0;i<arr.length;i++)
                chars[++idxL] = arr[i];
        }
    }
}