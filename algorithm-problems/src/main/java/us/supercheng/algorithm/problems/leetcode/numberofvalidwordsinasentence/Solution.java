package us.supercheng.algorithm.problems.leetcode.numberofvalidwordsinasentence;

public class Solution {

    public int countValidWords(String sentence) {
        if (sentence == null || sentence.length() < 1)
            return 0;

        int ret = 0;

        for (String a : sentence.split(" "))
            if (passCheck(a))
                ret++;

        return ret;
    }

    private boolean passCheck(String s) {
        int countH = 0;
        int countPu = 0;
        int idxH = -1;
        int idxPu = -1;
        int len = s.length();
        boolean hasLow = false;
        boolean allowed = false;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                return false;
            else if (c == '-' || c == '.' || c == ',' || c == '!')
                allowed = true;
            else if (Character.isLetter(c)) {
                if (c == Character.toUpperCase(c))
                    return false;
                else
                    hasLow = true;
            } else
                return false;

            if (c == '-') {
                countH++;
                idxH = i;
                if (countH == 2)
                    return false;
            }

            if (c == '.' || c == ',' || c == '!') {
                countPu++;
                idxPu = i;
                if (countPu == 2)
                    return false;
            }
        }

        if (!(countPu == 0 || countPu == 1 && idxPu == len - 1) ||
                !(countH == 0 || countH == 1 && idxH - 1 > -1 && idxH + 1 < len && Character.isLetter(s.charAt(idxH - 1)) && Character.isLetter(s.charAt(idxH + 1))))
            return false;

        return hasLow || allowed;
    }

}
