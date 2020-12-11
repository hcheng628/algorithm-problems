package us.supercheng.algorithm.problems.leetcode.ambiguouscoordinates;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> ambiguousCoordinates(String S) {
        List<String> ret = new ArrayList<>();
        int len = S.length()-1;

        for (int i=1;i<len;i++) {
            List<String> left = this.process(S.substring(1, i+1));
            if (left == null)
                continue;

            List<String> right = this.process(S.substring(i+1, len));
            if (right == null)
                continue;

            for (String l : left)
                for (String r : right)
                    ret.add(new StringBuilder("(").append(l).append(", ").append(r).append(")").toString());
        }

        return ret;
    }

    public List<String> process(String s) {
        if (s == null || s.length() < 1 || (s.length() != 1 && s.charAt(0) == '0' && s.charAt(s.length()-1) == '0'))
            return null;

        List<String> list = new ArrayList<>();
        boolean zero1 = s.charAt(0) == '0';

        if (!zero1 || s.length() == 1)
            list.add(s);

        if (s.charAt(s.length()-1) != '0')
            for (int i=1;i<s.length();i++) {
                list.add(new StringBuilder(s.substring(0,i)).append(".").append(s.substring(i)).toString());
                if (zero1)
                    break;
            }

        return list;
    }
}