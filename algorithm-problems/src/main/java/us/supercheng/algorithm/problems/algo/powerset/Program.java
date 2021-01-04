package us.supercheng.algorithm.problems.algo.powerset;

import java.util.*;

public class Program {

    public static List<List<Integer>> powerset_Solution1(List<Integer> array) {
        List<List<Integer>> ret = new ArrayList<>();
        if (array != null)
            ret.add(new ArrayList<>());

        helper(array, ret, new ArrayList<>(), 0);

        return ret;
    }

    private static void helper(List<Integer> array, List<List<Integer>> ret, List<Integer> list, int idx) {
        for (int i=idx; i<array.size(); i++) {
            list.add(array.get(i));
            ret.add(new ArrayList<>(list));
            helper(array, ret, list, i+1);
            list.remove(list.size() - 1);
        }

    }

    public static List<List<Integer>> powerset_Solution2(List<Integer> array) {
        List<List<Integer>> ret = new ArrayList<>();
        if (array != null) {
            ret.add(new ArrayList<>());
            for (int i=0, size = array.size(); i<size; i++)
                for (int j=0, currSize = ret.size(); j<currSize; j++) {
                    List<Integer> each = new ArrayList<>(ret.get(j));
                    each.add(array.get(i));
                    ret.add(each);
                }
        }

        return ret;
    }

    public static List<List<Integer>> powerset_Solution3(List<Integer> array) {
        return p(array, array.size() - 1);
    }

    private static List<List<Integer>> p(List<Integer> arr, int idx) {
        if (idx < 0) {
            List<List<Integer>> ret = new ArrayList<>();
            ret.add(new ArrayList<>());
            return ret;
        }

        List<List<Integer>> subSet = p(arr, idx - 1);
        List<List<Integer>> ret = new ArrayList<>(subSet);

        for (List<Integer> each : subSet) {
            List<Integer> retEach = new ArrayList<>(each);
            retEach.add(arr.get(idx));
            ret.add(retEach);
        }

        return ret;
    }
}

