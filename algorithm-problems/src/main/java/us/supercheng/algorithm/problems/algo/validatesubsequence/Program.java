package us.supercheng.algorithm.problems.algo.validatesubsequence;

import java.util.*;

public class Program {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int idxB = 0,
            lenA = array.size(),
            lenB = sequence.size();

        if (lenB > lenA)
            return false;

        for (int idxA = 0; idxA<lenA && idxB<lenB; idxA++)
            if (array.get(idxA) == sequence.get(idxB))
                idxB++;

        return idxB == lenB;
    }
}

