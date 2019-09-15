package us.supercheng.algorithm.problems.comparestringsbyfrequencyofthesmallestcharacter;

import java.util.Arrays;

class Solution {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int len = queries.length;
        int [] ret = new int [len];

        for (int i=0;i<len;i++) {
            int count = 0;
            for (String word : words)
                if (this.calF(queries[i]) < this.calF(word))
                    count++;
            ret[i] = count;
        }

        return ret;
    }

    private int calF(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length,
                ret = 1;
        Arrays.sort(chars);

        for (int i=0;i<len-1 && chars[i] == chars[0];i++)
            if (chars[i] == chars[i+1])
                ret++;

        return ret;
    }
}