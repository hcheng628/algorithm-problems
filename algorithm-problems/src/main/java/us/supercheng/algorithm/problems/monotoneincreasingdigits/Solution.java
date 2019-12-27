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

    public int monotoneIncreasingDigitsGreedy(int N) {
        if (N < 10)
            return N;

        String S = String.valueOf(N),
               ans = "";
        int len = S.length();
        StringBuilder sb = new StringBuilder();

        buildEachChar:
        for (int i=0;i<len;i++) {
            for (char c = '1';c <= '9'; c++) {
                if (S.compareTo(ans + this.buildStr(c, len-i, sb)) < 0) {
                    ans += (char) (c-1);
                    continue buildEachChar;
                }
            }
            ans += '9';
        }

        return Integer.parseInt(ans);
    }

    private String buildStr(char c, int len, StringBuilder sb) {
        if (sb.length() != 0)
            sb.setLength(0);
        for (int i=0;i<len;i++)
            sb.append(c);
        return sb.toString();
    }

    public int monotoneIncreasingDigitsOpt(int N) {
        if (N < 10)
            return N;

        char[] chars = String.valueOf(N).toCharArray();
        int idx = 1,
            len = chars.length;

        while (idx < len && chars[idx-1] <= chars[idx])
            idx++;

        while (idx < len && idx > 0 && chars[idx-1] > chars[idx])
            chars[--idx]--;

        for (int i=idx+1;i<len;i++)
            chars[i] = '9';

        return Integer.parseInt(new String(chars));
    }
}