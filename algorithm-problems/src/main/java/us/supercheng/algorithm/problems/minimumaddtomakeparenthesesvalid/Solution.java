package us.supercheng.algorithm.problems.minimumaddtomakeparenthesesvalid;

public class Solution {

    public int minAddToMakeValid(String S) {
        int left = 0,
            right = 0;

        for (int i=0, len=S.length(); i<len; i++)
            if (S.charAt(i) == '(')
                left++;
            else
            if (left == 0)
                right++;
            else
                left--;

        return left + right;
    }

}