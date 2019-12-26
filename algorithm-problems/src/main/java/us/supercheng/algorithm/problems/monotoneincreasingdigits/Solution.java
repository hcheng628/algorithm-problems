package us.supercheng.algorithm.problems.monotoneincreasingdigits;

public class Solution {

    public int monotoneIncreasingDigits(int N) {
        if (N < 10)
            return N;

        int next = this.helper((N + "").toCharArray(), N);
        while (N != next) {
            N = next;
            next = this.helper((next+"").toCharArray(), next);
        }

        return next;
    }

    private int helper(char[] chars, int N) {
        int idx = 0,
                len = chars.length;

        doCal: {
            for (;idx<len-1;idx++)
                if (chars[idx] > chars[idx+1])
                    break doCal;
            return N;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<idx;i++)
            sb.append(chars[i]);
        sb.append((chars[idx]- '0')- 1);
        for (int i=idx+1;i<len;i++)
            sb.append('9');

        return Integer.parseInt(sb.toString());
    }
}