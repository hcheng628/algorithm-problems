package us.supercheng.algorithm.problems.leetcode.maximumproductofwordlengths;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxProduct(String[] words) {
        int ret = 0;
        List<boolean[]> map = new ArrayList<>();

        for (int i=0;i<words.length;i++) {
            boolean [] set = new boolean [26];
            for (int j=0;j<words[i].length();j++)
                set[words[i].charAt(j) - 'a'] = true;
            map.add(set);
        }

        for (int first=0;first<words.length;first++)
            for (int second=first+1;second<words.length;second++) {
                int len = words[first].length() * words[second].length();
                if (ret == 0) {
                    if (this.containSameLetter(map, first, second))
                        ret = len;
                } else {
                    if (len > ret && this.containSameLetter(map, first, second))
                        ret = len;
                }
            }
        return ret;
    }

    public boolean containSameLetter(List<boolean[]> map, int indexA, int indexB) {
        boolean[] setA = map.get(indexA),
                setB = map.get(indexB);

        for (int i=0;i<26;i++)
            if(setA[i] && setB[i])
                return false;
        return true;
    }

    public int maxProduct2(String[] words) {
        int ret = 0;
        int [] wordBits = new int [words.length];

        for (int i=0;i<words.length;i++)
            for(int j=0;j<words[i].length();j++)
                wordBits[i] |= 1 << (words[i].charAt(j) - 'a');

        for (int first=0;first<words.length;first++)
            for (int second=first+1;second<words.length;second++)
                if ((wordBits[first] & wordBits[second]) == 0)
                    ret = Math.max(ret, words[first].length() * words[second].length());
        return ret;
    }
}