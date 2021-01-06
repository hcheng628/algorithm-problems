package us.supercheng.algorithm.problems.algo.longestpalindromicsubstring;

public class Program {

    public static String longestPalindromicSubstring(String str) {
        String ret = "";

        for (int i=0, retMax=0, len=str.length(); i<len; i++) {
            String s = getP(str, len, i - 1, i + 1);
            if (s.length() > retMax) {
                retMax = s.length();
                ret = s;
            }

            s = getP(str, len, i - 1, i);
            if (s.length() > retMax) {
                retMax = s.length();
                ret = s;
            }
        }

        return ret;
    }

    private static String getP(String s, int len, int l, int r) {
        while (l > -1 && r<len && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

}