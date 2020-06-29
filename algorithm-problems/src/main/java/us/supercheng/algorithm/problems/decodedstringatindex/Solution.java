package us.supercheng.algorithm.problems.decodedstringatindex;

public class Solution {

    public String decodeAtIndex(String S, int K) {
        long idx = 0;

        for (int i=0, len = S.length(); i<len; i++) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                int repeat = c - '0';

                if (idx * repeat < K)
                    idx *= repeat;
                else if (K % idx == 0)
                    return this.decodeAtIndex(S.substring(0, i), (int)idx);
                else
                    return this.decodeAtIndex(S.substring(0, i), K % (int)idx);
            } else {
                idx++;
                if (idx == K)
                    return c + "";
            }
        }

        return "";
    }
}