package us.supercheng.algorithm.problems.uniquesubstringsinwraparoundstring;

import java.util.HashSet;
import java.util.Set;


class Solution {

    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() < 1)
            return 0;

        int ret = 0, len = 1;
        int[] count = new int[26];
        char[] chars = p.toCharArray();

        count[chars[0]-'a'] = 1;

        for (int i=1;i<chars.length;i++) {
            if (chars[i] == chars[i-1] + 1 || chars[i] == 'a' && chars[i-1] == 'z')
                len++;
            else
                len = 1;
            count[chars[i]-'a'] = Math.max(count[chars[i]-'a'], len);
        }

        for (int each : count)
            ret += each;

        return ret;
    }

    Set<String> set;

    public int findSubstringInWraproundStringTLE(String p) {
        this.set = new HashSet<>();
        char[] chars = p.toCharArray();
        this.check(chars);
        return this.set.size();
    }

    private void check(char[] chars) {
        for (int i=0;i<chars.length;i++)
            for (int j=chars.length;j>i;j--) {
                String temp = new String(chars, i, j-i);
                if (!set.contains(temp) && this.checkStr(chars, i, j-1)) {
                    set.add(temp);
                    this.setHelper(chars, i, j);
                    i=j-1;
                }
            }
    }

    private boolean checkStr(char[] chars, int start, int end) {
        for (int i=start;i<end;i++)
            if (chars[i] != 'z')
                if (chars[i+1] - chars[i] != 1)
                    return false;
            else
                if (chars[i+1] != 'a')
                    return false;
        return true;
    }

    private void setHelper(char[] chars, int start, int end) {
        for (int i=start;i<=end;i++)
            for (int j=end;j>i;j--) {
                int offset = j-i-start;
                if (offset > 0)
                    this.set.add(new String(chars, i-start, offset));
            }
    }

    private void echo(Object o) {
        System.out.println(o);
    }
}