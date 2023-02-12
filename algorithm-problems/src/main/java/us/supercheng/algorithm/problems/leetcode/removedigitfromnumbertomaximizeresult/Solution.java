package us.supercheng.algorithm.problems.leetcode.removedigitfromnumbertomaximizeresult;

class Solution {

    public String removeDigit(String number, char digit) {
        int idx = -1;
        for (int i = 0, len = number.length(); i < len; i++)
            if (number.charAt(i) == digit) {
                if (i + 1 < len && digit < number.charAt(i + 1))
                    return String.join("", number.substring(0, i), number.substring(i + 1));
                idx = i;
            }

        return String.join("", number.substring(0, idx), number.substring(idx + 1));
    }

}
