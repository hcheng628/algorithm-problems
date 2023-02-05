package us.supercheng.algorithm.problems.leetcode.divideastringintogroupsofsizek;

class Solution {

    public String[] divideString(String s, int k, char fill) {
        String[] ret = new String[s.length() / k + (s.length() % k == 0 ? 0 : 1)];

        for (int i = 0, idx = 0, sLen = s.length(); i < sLen; i += k) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < k; j++)
                sb.append(j + i < sLen ? s.charAt(j + i) : fill);
            ret[idx++] = sb.toString();
        }

        return ret;
    }

}
