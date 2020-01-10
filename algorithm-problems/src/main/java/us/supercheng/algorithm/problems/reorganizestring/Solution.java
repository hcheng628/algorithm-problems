package us.supercheng.algorithm.problems.reorganizestring;

public class Solution {

    public String reorganizeString(String S) {
        int[] count = new int[26];
        StringBuilder sb = new StringBuilder();

        for (char c : S.toCharArray())
            count[c-'a']++;

        char c = this.getNextChar(count, -1);
        if (c != '!')
            sb.append(c);

        for (int i=1,len=S.length();c!='!'&&i<len;i++) {
            c = this.getNextChar(count, c - 'a');
            if (c == '!')
                return "";
            sb.append(c);
        }

        return sb.toString();
    }

    private char getNextChar(int[] count, int noIdx) {
        int idx = -1,
            max = 0;

        for (int i=0;i<26;i++)
            if (i != noIdx && count[i] > max) {
                idx = i;
                max = count[i];
            }

        if (idx == -1)
            return '!';
        count[idx]--;

        return (char) (idx + 'a');
    }
}