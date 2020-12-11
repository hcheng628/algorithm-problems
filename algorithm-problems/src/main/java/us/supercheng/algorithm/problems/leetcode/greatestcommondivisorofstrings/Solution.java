package us.supercheng.algorithm.problems.leetcode.greatestcommondivisorofstrings;

class Solution {

    public String gcdOfStrings(String str1, String str2) {
        int len2 = str2.length();
        for (int idx = len2;idx>0;idx--)
            if (len2 % idx == 0) {
                String retVal = this.gcd(str1, str2.substring(0, idx));
                if (retVal.length() > 0)
                    return retVal;
            }
        return "";
    }

    private String gcd(String s1, String s2) {
        int len1 = s1.length(),
                len2 = s2.length();

        if (len2 >= len1) {
            if (len2 == len1 && s1.equals(s2))
                return s1;
            return "";
        } else {
            int idx=0;
            for (;idx<len2;idx++)
                if (s1.charAt(idx) != s2.charAt(idx))
                    return "";
            return this.gcd(s1.substring(idx, len1), s2);
        }
    }

    private void echo(Object o ) {
        //System.out.println(o);
    }
}