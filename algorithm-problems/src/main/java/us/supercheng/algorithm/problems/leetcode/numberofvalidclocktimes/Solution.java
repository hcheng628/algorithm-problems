package us.supercheng.algorithm.problems.leetcode.numberofvalidclocktimes;

class Solution {

    public int countTime(String time) {
        int first = time.charAt(0) == '?' ? 3 : 1;
        int second = time.charAt(1) == '?' ? 0 : 1;
        int third = time.charAt(3) == '?' ? 6 : 1;
        int forth = time.charAt(4) == '?' ? 10 : 1;

        if (first == 3 && (second != 0 && time.charAt(1) > '3'))
            first = 2;

        if (second == 0)
            if (time.charAt(0) == '?') {
                int ret = 0;
                for (int i = 0; i < 3; i++)
                    ret += (i == 2 ? 4 : 10) * third * forth;
                return ret;
            } else if (time.charAt(0) == '0' || time.charAt(0) == '1')
                second = 10;
            else
                second = 4;

        return first * second * third * forth;
    }

}
