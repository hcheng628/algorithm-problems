package us.supercheng.algorithm.problems.leetcode.complementofbase10integer;

class Solution {
    public int bitwiseComplement(int N) {
        char[] chars = Integer.toBinaryString(N).toCharArray();
        int ret = 0;

        for (int p=chars.length-1,i=0;p>-1;p--,i++)
            if (chars[i] == '0')
                ret += (int)Math.pow(2, p);

        return ret;
    }
}