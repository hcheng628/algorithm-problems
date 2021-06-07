package us.supercheng.algorithm.problems.algo.knuthmorrisprattalgorithm;

import java.util.*;

public class Program {

    // Time: O(m*n) Space: O(1)
    public static boolean knuthMorrisPrattAlgorithm_Solution1(String string, String substring) {
        int jLen=substring.length();

        for (int i=0, iLen=string.length(); i<iLen; i++) {
            int j=0;
            for (int ii=i; j<jLen; ii++, j++)
                if (string.charAt(ii) != substring.charAt(j))
                    break;

            if (j == jLen)
                return true;
        }

        return false;
    }

    // Time: O(m+n)     Space: O(min(m,n))
    public static boolean knuthMorrisPrattAlgorithm(String string, String substring) {
        int[] subIdx = buildStrIdx(substring);

        for (int i=0, j=0, sLen=string.length(), subLen=substring.length(); j < subLen && i < sLen; )
            if (string.charAt(i) == substring.charAt(j)) {
                i++;
                j++;
                if (j == subLen)
                    return true;
            } else
                if (j == 0)
                    i++;
                else
                    j = subIdx[j];

        return false;
    }

    private static int[] buildStrIdx(String s) {
        int len = s.length();
        int[] ret = new int[len + 1];

        for (int i = 0, idx = i + 1;idx < len && i < len; )
            if (s.charAt(idx) == s.charAt(i)) {
                i++;
                ret[++idx] = i;
            } else {
                if (ret[i] != 0)
                    i = ret[i];
                else {
                    i = 0;
                    idx++;
                }
            }

        return ret;
    }

}
