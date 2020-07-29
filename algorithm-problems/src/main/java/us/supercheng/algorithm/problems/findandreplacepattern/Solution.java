package us.supercheng.algorithm.problems.findandreplacepattern;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ret = new ArrayList<>();
        pattern = this.ps(pattern);

        for (String w : words)
            if (this.sameP(this.ps(w), pattern))
                ret.add(w);

        return ret;
    }

    private boolean sameP(String s, String pat) {
        int len = s.length(),
                pLen = pat.length();

        if (len < pLen || len % pLen != 0)
            return false;

        for (int idx = 0; idx < len; idx++)
            if (s.charAt(idx) != pat.charAt(idx % pLen))
                return false;

        return true;
    }

    private String ps(String s) {
        int idx = 0;
        char c = 'a';
        Character[] used = new Character[26];
        StringBuilder sb = new StringBuilder();

        for (int i=0, len=s.length(); i<len; i++) {
            int ii = s.charAt(i) - 'a';
            if (used[ii] == null)
                used[ii] = (char) (c + idx++);
            sb.append(used[ii]);
        }

        return sb.toString();
    }
}
