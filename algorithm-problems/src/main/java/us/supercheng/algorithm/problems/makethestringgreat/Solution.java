package us.supercheng.algorithm.problems.makethestringgreat;

public class Solution {

    public String makeGood(String s) {

        while (true) {
            int idx = this.check(s);
            if (idx == -1)
                break;
            s = s.substring(0, idx-1) + s.substring(idx+1);
        }

        return s;
    }

    private int check(String s) {
        if (s == null || s.length() < 2)
            return -1;

        for (int i=1, len=s.length(); i<len; i++) {
            char a = s.charAt(i-1),
                 b = s.charAt(i);
            if (a != b && Character.toUpperCase(a) == Character.toUpperCase(b))
                return i;
        }

        return -1;
    }
}