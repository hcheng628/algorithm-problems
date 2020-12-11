package us.supercheng.algorithm.problems.leetcode.comparestringsbyfrequencyofthesmallestcharacter;

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

    public int[] numSmallerByFrequencyBinarySearch(String[] queries, String[] words) {
        int qLen = queries.length,
            wLen = words.length;

        int[] qMap = new int [qLen],
              wMap = new int [wLen],
              ret = new int [qLen];

        for (int i=0;i<qLen;i++)
            qMap[i] = this.calF2(queries[i].toCharArray());
        for (int i=0;i<wLen;i++)
            wMap[i] = this.calF2(words[i].toCharArray());
        Arrays.sort(wMap);

        for (int i=0;i<qLen;i++) {
            int left = 0,
                right = wLen-1;

            while (right >= left) {
                int mid = left + (right - left) / 2;
                if (wMap[mid] > qMap[i])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            ret[i] = wLen - left;
        }

        return ret;
    }

    private int calF2(char[] chars) {
        int [] bucket = new int [26];
        for (char c : chars)
            bucket[c-'a']++;

        for (int i=0;i<26;i++)
            if (bucket[i]!=0)
                return bucket[i];
        return -1;
    }
}