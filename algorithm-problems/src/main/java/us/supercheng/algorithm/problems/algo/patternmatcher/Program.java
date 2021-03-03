package us.supercheng.algorithm.problems.algo.patternmatcher;

import java.util.*;

public class Program {

    public static String[] patternMatcher(String pattern, String str) {
        char[] p = normPattern(pattern);
        int[] countInfo = countXY(p);

        for (int xLen=1, baseYIdx = firstYIdx(p), len = str.length(); xLen <= len; xLen++) {
            String x = str.substring(0, xLen);
            int yLen = getYLenByX(len, countInfo, xLen);
            if (yLen == -1)
                continue;

            String y = baseYIdx != -1 ? str.substring(xLen * baseYIdx, xLen * baseYIdx + yLen) : "";
            if (buildS(p, x, y).equals(str))
                return p[0] == pattern.charAt(0) ? new String[]{x, y} : new String[]{y, x};
        }

        return new String[] {};
    }

    private static int getYLenByX(int len, int[] countInfo, int xLen) {
        if (countInfo[1] == 0)
            return 0;

        int totalY = len - (countInfo[0] * xLen);
        if (totalY <= 0 || totalY < countInfo[1] || totalY % countInfo[1] != 0)
            return -1;

        return totalY / countInfo[1];
    }

    private static int firstYIdx(char[] p) {
        for (int i=0, len=p.length; i<len; i++)
            if (p[i] == 'y')
                return i;
        return -1;
    }

    private static String buildS(char[] p, String x, String y) {
        StringBuilder sb = new StringBuilder();

        for (int i=0, len=p.length; i<len; i++)
            sb.append(p[i] == 'x' ? x : y);

        return sb.toString();
    }

    private static int[] countXY(char[] p) {
        int x = 0;
        int y = 0;

        for (char pp : p)
            if (pp == 'x')
                x++;
            else
                y++;

        return new int[]{x, y};
    }

    private static char[] normPattern(String p) {
        char[] ret = p.toCharArray();
        if (ret[0] == 'x')
            return ret;

        for (int i=0, len = p.length(); i<len; i++)
            ret[i] = ret[i] == 'x' ? 'y' : 'x';

        return ret;
    }

}


