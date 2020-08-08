package us.supercheng.algorithm.problems.maximumscoreaftersplittingastring;

public class Solution {

    public int maxScore(String s) {
        int ret = 0;

        for (int i=1, len = s.length(); i<len; i++) {
            int left = 0,
                right = 0;

            for (int l=0; l<i; l++)
                if (s.charAt(l) == '0')
                    left++;

            for (int r=i; r<len; r++)
                if (s.charAt(r) == '1')
                    right++;

            ret = Math.max(left+right, ret);
        }

        return ret;
    }
}