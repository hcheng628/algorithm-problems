package us.supercheng.algorithm.problems.algo.interweavingstrings;

import java.util.*;

public class Program {

    private static Boolean [][] memo;

    // Time: O(2^m+n) Space: O(m*n)
    public static boolean interweavingStrings(String one, String two, String three) {
        if (one.length() + two.length() != three.length())
            return false;

        memo = new Boolean[one.length() + 1][two.length() + 1];
        return helper(one, two, three, 0, 0, 0);
    }

    private static boolean helper(String a, String b, String c, int idxA, int idxB, int idxC) {
        if (idxA == a.length())
            return b.substring(idxB).equals(c.substring(idxC));
        else if (idxB == b.length())
            return a.substring(idxA).equals(c.substring(idxC));

        if (memo[idxA][idxB] != null)
            return memo[idxA][idxB];
        memo[idxA][idxB] = false;

        char charA = a.charAt(idxA);
        char charB = b.charAt(idxB);
        char charC = c.charAt(idxC);

        if (charA == charB && charA == charC)
            memo[idxA][idxB] = helper(a, b, c, idxA + 1, idxB, idxC + 1) ||
                    helper(a, b, c, idxA, idxB + 1, idxC + 1);
        else if (charA == charC)
            memo[idxA][idxB] = helper(a, b, c, idxA + 1, idxB, idxC + 1);
        else if (charB == charC)
            memo[idxA][idxB] = helper(a, b, c, idxA, idxB + 1, idxC + 1);

        return memo[idxA][idxB];
    }

    // Time: O(m*n) Space: O(m*n)
    public static boolean interweavingStrings_Solution2(String one, String two, String three) {
        if (one.length() + two.length() != three.length())
            return false;

        memo = new Boolean[one.length() + 1][two.length() + 1];
        return one.length() + two.length() == three.length() &&
                process(one, two, three, 0, 0, 0);
    }

    private static boolean process(String a, String b, String c, int idxA, int idxB, int idxC) {
        if (idxA == a.length() && idxB == b.length() && idxC == c.length())
            return true;

        if (memo[idxA][idxB] != null)
            return memo[idxA][idxB];

        char curr = c.charAt(idxC);
        return memo[idxA][idxB] = (idxA < a.length() && curr == a.charAt(idxA) && process(a, b, c, idxA + 1, idxB, idxC + 1)) ||
            (idxB < b.length() && curr == b.charAt(idxB) && process(a, b, c, idxA, idxB + 1, idxC + 1));
    }
}
