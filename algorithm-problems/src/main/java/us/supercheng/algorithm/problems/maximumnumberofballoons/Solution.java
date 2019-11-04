package us.supercheng.algorithm.problems.maximumnumberofballoons;

class Solution {

    public int maxNumberOfBalloons(String text) {
        if (text == null || text.length() < 7)
            return 0;

        int[] bucket = new int[26];
        int ret = 0;

        for (char c : text.toCharArray())
            if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n')
                bucket[c-'a']++;

        for (;bucket[0] > 0 && bucket[1] > 0 && bucket[11]>1 && bucket[14]>1 && bucket[13]>0;ret++) {
            bucket[0]--;
            bucket[1]--;
            bucket[11] -=2;
            bucket[14] -=2;
            bucket[13]--;
        }

        return ret;
    }
}