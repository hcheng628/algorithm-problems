package us.supercheng.algorithm.problems.algo.interweavingstrings;

import java.util.*;

public class Program {

    private static Boolean [][] memo;

    public static boolean interweavingStrings(String one, String two, String three) {
        memo = new Boolean[one.length()][two.length()];
        boolean res = helper(one, two, three, 0, 0, 0);
        for (Boolean[] m : memo)
            System.out.println(Arrays.toString(m));
        return res;
    }

    private static boolean sameStrs(String a, String b, int idxA, int idxB) {
        if (a.length() - idxA != b.length() - idxB)
            return false;

        for (int i=0, len=b.length() - idxB; i<len; i++)
            if (a.charAt(i + idxA) != b.charAt(i + idxB))
                return false;

        return true;
    }

    private static boolean helper(String a, String b, String c, int idxA, int idxB, int idxC) {
        if (idxA == a.length())
            return sameStrs(b, c, idxB, idxC);
        else if (idxB == b.length())
            return sameStrs(a, c, idxA, idxC);

        if (memo[idxA][idxB] != null)
            return memo[idxA][idxB];

        char charA = a.charAt(idxA);
        char charB = b.charAt(idxB);
        char charC = c.charAt(idxC);

        if (charA == charB)
            memo[idxA][idxB] = charA == charC &&
                    helper(a, b, c, idxA + 1, idxB, idxC + 1) ||
                    helper(a, b, c, idxA, idxB + 1, idxC + 1);
        else {
            if (charA == charC)
                memo[idxA][idxB] =  helper(a, b, c, idxA + 1, idxB, idxC + 1);
            else if (charB == charC)
                memo[idxA][idxB] =  helper(a, b, c, idxA, idxB + 1, idxC + 1);
            else
                memo[idxA][idxB] =  false;
        }

        return memo[idxA][idxB];

    }
}