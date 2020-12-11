package us.supercheng.algorithm.problems.leetcode.sortcharactersbyfrequency;

class Solution {
    public String frequencySort(String s) {
        if(s == null)
            return "";
        else if (s.length() < 3)
            return s;

        int [] countArr = new int [128];
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int max = 0;

        for (int i=0;i<chars.length;i++)
            max = Math.max(++countArr[chars[i]], max);

        while(true) {
            int newMax = 0;
            for(int i=0;i<128;i++) {
                if(countArr[i] == max) {
                    for (int j=0;j<max;j++)
                        sb.append((char)i);
                    countArr[i] = 0;
                } else
                    newMax = Math.max(countArr[i], newMax);
            }
            if (newMax == 0)
                break;
            max = newMax;
        }

        return sb.toString();
    }
}