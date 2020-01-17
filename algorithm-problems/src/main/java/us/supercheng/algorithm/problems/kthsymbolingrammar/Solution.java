package us.supercheng.algorithm.problems.kthsymbolingrammar;

public class Solution {

    public int kthGrammar(int N, int K) {
        if (N == 1)
            return 0;

        int prevLen = (int) Math.pow(2, N-2);
        if (K <= prevLen)
            return this.kthGrammar(N-1, K);
        else if (prevLen * 2 == K)
            return this.kthGrammar(N-1, prevLen) == 1 ? 0 : 1;
        else
            return this.kthGrammar(N-1, K % prevLen) == 1 ? 0 : 1;
    }

    public int kthGrammarMLE(int N, int K) {
        String dp = "0";
        for (int i=1;i<N;i++) {
            StringBuilder sb = new StringBuilder();
            for (int idx=0, len=dp.length();idx<len;idx++)
                if (dp.charAt(idx) == '0')
                    sb.append("01");
                else
                    sb.append("10");
            dp = sb.toString();
        }
        return dp.charAt(K-1) - '0';
    }
}