package us.supercheng.algorithm.problems.algo.longestpalindromicsubstring;

public class Program {

    public static String longestPalindromicSubstring_Solution1(String str) {
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

    public static String longestPalindromicSubstring_Solution2(String str) {
        String ret = "";
        for (int i=0, len=str.length(); i<len; i++)
            for (int j=i; j<len; j++)
                if (j-i+1 > ret.length()) {
                    String s = str.substring(i, j+1);
                    if (isP(s))
                        ret = s;
                }
        return ret;
    }

    private static boolean isP(String s) {
        for (int l = 0,r = s.length() - 1; l <= r; l++, r--)
            if (s.charAt(l) != s.charAt(r))
                return false;
        return true;
    }

}