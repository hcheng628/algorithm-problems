package us.supercheng.algorithm.problems.leetcode.utf8validation;

class Solution {

    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0)
            return true;

        int count = 0;
        boolean isPart = false;
        StringBuilder sb = null;

        for (int i=0;i<data.length;i++) {
            if (data[i] > 247)
                return false;

            sb = new StringBuilder(Integer.toBinaryString(data[i]));
            while (sb.length() != 8)
                sb.insert(0, "0");
            String s = sb.toString();

            if (isPart) {
                if (this.checkValidPart(s))
                    count--;
                else
                    return false;
                if (count == 0)
                    isPart = false;
            } else {
                if (this.checkValidPart(s))
                    return false;
                count = this.getCount(s);
                if (count > 0)
                    isPart = true;
                else if (count == -1)
                    count = 0;
            }
        }

        return count == 0;
    }

    private int getCount(String s) {
        int count = 0;
        if (s.charAt(0) == '1') {
            count++;
            if (s.charAt(1) == '1') {
                count++;
                if (s.charAt(2) == '1') {
                    count++;
                    if (s.charAt(3) == '1')
                        count++;
                }
            }
        }
        return --count;
    }

    private boolean checkValidPart(String s) {
        return s.charAt(0) == '1' && s.charAt(1) == '0';
    }
}