package us.supercheng.algorithm.problems.palindromicsubstrings;

class Solution {

    Boolean[][] memo;

    public int countSubstrings(String s) {
        char [] chars = s.toCharArray();
        int len = chars.length,
                ret = 0;
        this.memo = new Boolean[len][len];
        this.searchPA(chars, 0, len-1);

        for (Boolean[] row : this.memo)
            for (Boolean each : row)
                if (each != null && each)
                    ret++;
        return ret;
    }

    private void searchPA(char[] chars, int left, int right) {
        if (this.memo[left][right] != null)
            return;

        int from = left,
                to = right;

        if (left == right) {
            this.memo[left][right] = true;
            return;
        } else {
            boolean isPa = true;
            while (isPa && from <= right) {
                if (chars[from] == chars[to]) {
                    from++;
                    to--;
                } else {
                    isPa = false;
                    this.memo[left][right] = false;
                }
            }

            if (isPa)
                this.memo[left][right] = true;

            // cut left
            if (left + 1 <= right)
                this.searchPA(chars, left+1, right);

            // cut right
            if (right - 1 >= left)
                this.searchPA(chars, left, right-1);
        }
    }

    public int countSubstringsDP(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length,
                ret = len;
        boolean[][] dp = new boolean[len][len];

        for (int i=0;i<len;i++) {   // init dp
            dp[i][i] = true;
            if (i+1<len && chars[i] == chars[i+1]) {
                dp[i][i+1] = true;
                ret++;
            }
        }

        // first == last and inner inclusive dp is true
        for (int currLen=3;currLen<=len;currLen++)
            for (int i=0;i<=len-currLen;i++) {
                dp[i][i+currLen-1] = dp[i+1][i+currLen-2] && chars[i] == chars[i+currLen-1];
                if (dp[i][i+currLen-1])
                    ret++;
            }

        return ret;
    }

    public int countSubstringsExpandSearch(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length,
                ret = 0;

        for (int i=0;i<len;i++)
            ret += this.countPa(chars, i, i) + this.countPa(chars, i, i+1);

        return ret;
    }

    private int countPa(char[] chars, int left, int right) {
        int ret = 0;
        while (left>=0 && right<chars.length && chars[left--] == chars[right++])
            ret++;

        return ret;
    }

    private void echo(Object o) {
        System.out.println(o);
    }
}