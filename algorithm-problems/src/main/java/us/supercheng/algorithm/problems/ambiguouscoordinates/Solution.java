package us.supercheng.algorithm.problems.ambiguouscoordinates;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> ambiguousCoordinates(String S) {
        List<String> ret = new ArrayList<>();
        int len = S.length()-1;

        for (int i=1;i<len;i++) {
            List<String> left = this.process(S.substring(1, i+1)),
                    right = this.process(S.substring(i+1, len));
            for (String l : left)
                for (String r : right)
                    ret.add( "(" + l +", " + r + ")");
        }

        return ret;
    }

    public List<String> process(String s) {
        if (s == null || s.length() < 1 || this.allZeros(s))
            return new ArrayList<>();

        List<String> list = new ArrayList<>();
        boolean zero1 = s.charAt(0) == '0';

        if (!zero1 || s.length() == 1)
            list.add(s);

        if (s.charAt(s.length()-1) != '0')
            for (int i=1;i<s.length();i++) {
                list.add(s.substring(0,i) + "." + s.substring(i));
                if (zero1)
                    break;
            }

        return list;
    }


    private boolean allZeros(String s) {
        if (s.length() == 1)
            return false;

        for (int i=0;i<s.length();i++)
            if (s.charAt(i) != '0')
                return false;

        return true;
    }
}