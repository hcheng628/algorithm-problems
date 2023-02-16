package us.supercheng.algorithm.problems.leetcode.strongpasswordcheckerii;

class Solution {

    public boolean strongPasswordCheckerII(String password) {
        if (password == null || password.length() < 8)
            return false;

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (int i = 0, len = password.length(); i < len; i++) {
            char c = password.charAt(i);

            if (i != 0 && password.charAt(i - 1) == c)
                return false;

            if (!(hasUpper && hasLower) && Character.isLetter(c)) {
                if (!hasUpper && Character.toUpperCase(c) == c)
                    hasUpper = true;
                if (!hasLower && Character.toLowerCase(c) == c)
                    hasLower = true;
            }

            if (!hasDigit && Character.isDigit(c))
                hasDigit = true;

            if (!hasSpecial && "!@#$%^&*()-+".indexOf(c) > -1)
                hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

}
