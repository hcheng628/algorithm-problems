package us.supercheng.algorithm.problems.algo.samebsts;

import java.util.*;

public class Program {

    public static boolean sameBsts_Solution1(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.isEmpty())
            return true;
        else if (arrayOne.size() != arrayTwo.size() || arrayOne.get(0) != arrayTwo.get(0))
            return false;

        int val = arrayOne.get(0);

        List<Integer> leftOne = new ArrayList<>();
        List<Integer> leftTwo = new ArrayList<>();
        List<Integer> rightOne = new ArrayList<>();
        List<Integer> rightTwo = new ArrayList<>();

        for (int i=1, size = arrayOne.size(); i<size; i++) {
            if (arrayOne.get(i) < val)
                leftOne.add(arrayOne.get(i));
            else
                rightOne.add(arrayOne.get(i));

            if (arrayTwo.get(i) < val)
                leftTwo.add(arrayTwo.get(i));
            else
                rightTwo.add(arrayTwo.get(i));
        }

        if (!sameBsts_Solution1(leftOne, leftTwo))
            return false;
        return sameBsts_Solution1(rightOne, rightTwo);
    }

    public static boolean sameBsts_Solution2(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() != arrayTwo.size())
            return false;
        return same(arrayOne, arrayTwo, arrayOne.size(), 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean same(List<Integer> one, List<Integer> two, int SIZE, int idxOne, int idxTwo, int minVal, int maxVal) {
        if (one.get(idxOne) != two.get(idxTwo))
            return false;

        int rootVal = one.get(idxOne);
        int nextOneIdx = -1;
        int nextTwoIdx = -1;

        // Left
        for (int i=idxOne+1; nextOneIdx==-1 && i<SIZE; i++)
            if (one.get(i) < rootVal && one.get(i) >= minVal)
                nextOneIdx = i;

        for (int i=idxTwo+1; nextTwoIdx==-1 && i<SIZE; i++)
            if (two.get(i) < rootVal && two.get(i) >= minVal)
                nextTwoIdx = i;

        if ((nextOneIdx == -1 && nextTwoIdx != -1) ||
                (nextOneIdx != -1 && nextTwoIdx == -1) ||
                (nextOneIdx != -1 && nextTwoIdx != -1 && !same(one, two, SIZE, nextOneIdx, nextTwoIdx, minVal, rootVal)))
            return false;

        // Right
        nextOneIdx = -1;
        nextTwoIdx = -1;
        for (int i=idxOne+1; nextOneIdx==-1 && i<SIZE; i++)
            if (one.get(i) >= rootVal && one.get(i) < maxVal)
                nextOneIdx = i;

        for (int i=idxTwo+1; nextTwoIdx==-1 && i<SIZE; i++)
            if (two.get(i) >= rootVal && two.get(i) < maxVal)
                nextTwoIdx = i;

        return (nextOneIdx == -1 && nextTwoIdx == -1) || nextOneIdx != -1 && nextTwoIdx != -1 && same(one, two, SIZE, nextOneIdx, nextTwoIdx, rootVal, maxVal);
    }

}