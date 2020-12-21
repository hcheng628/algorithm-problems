package us.supercheng.algorithm.problems.algo.moveelementtoend;

import java.util.*;

public class Program {

    public static List<Integer> moveElementToEnd_Solution1(List<Integer> array, int toMove) {
        if (array == null || array.size() < 2)
            return new ArrayList<>();

        Collections.sort(array);

        int len = array.size(),
            idx = Collections.binarySearch(array, toMove),
            start = idx,
            end = idx;
        boolean searchStart = false,
                searchEnd = false;

        if (idx < 0)
            return array;

        for (; start>-1 && array.get(start) == toMove; start--)
            if (!searchStart)
                searchStart = true;
        if (searchStart)
            start++;

        for (; end<len && array.get(end) == toMove; end++)
            if (!searchEnd)
                searchEnd = true;
        if (searchEnd)
            end--;

        for (int i=0, count=len-end-1; count>0; i++, count--)
            array.set(start+i, array.get(end+1+i));

        for (int count=end-start+1, last=len-1; count>0; last--, count--)
            array.set(last, toMove);

        return array;
    }

    public static List<Integer> moveElementToEnd_Solution2(List<Integer> array, int toMove) {
        int len = array.size(),
            left = 0,
            right = len - 1;

        while (left < right) {
            if (array.get(right) == toMove) {
                right--;
                continue;
            }

            if (array.get(left) == toMove) {
                array.set(left, array.get(right));
                array.set(right--, toMove);
            }

            left++;
        }

        return array;
    }

    public static List<Integer> moveElementToEnd_Solution3(List<Integer> array, int toMove) {
        if (array == null || array.size() < 2)
            return array;

        Collections.sort(array);
        int idx = Collections.binarySearch(array, toMove),
            len = array.size();

        if (idx < 0)
            return array;

        while (idx - 1 > -1 && array.get(idx - 1) == toMove)
            idx--;

        for (int i=len-1; i>idx; i--) {
            array.set(idx++, array.get(i));
            array.set(i, toMove);
        }

        return array;
    }
}
