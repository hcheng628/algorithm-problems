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

    private void echo(Object o) {
        System.out.println(o);
    }
}