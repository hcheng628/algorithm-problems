package us.supercheng.algorithm.problems.pushdominoes;

public class Solution {

    public String pushDominoes(String dominoes) {
        char[] chars = ("L" + dominoes + "R").toCharArray();
        int len = chars.length;
        StringBuilder sb = new StringBuilder();

        for (int left=0,right=1; right<len; right++) {
            if (chars[right] == '.')
                continue;

            if (left > 0)
                sb.append(chars[left]);

            int middleEx = right - left - 1;
            if (chars[left] == chars[right])
                for (int i=0; i<middleEx; i++)
                    sb.append(chars[right]);
            else if (chars[left] == 'L' && chars[right] == 'R')
                for (int i=0; i<middleEx; i++)
                    sb.append('.');
            else {
                int half = middleEx / 2;
                for (int i=0; i<half; i++)
                    sb.append('R');
                if (middleEx % 2 != 0)
                    sb.append('.');
                for (int i=0; i<half; i++)
                    sb.append('L');
            }
            left = right;
        }

        return sb.toString();
    }
}