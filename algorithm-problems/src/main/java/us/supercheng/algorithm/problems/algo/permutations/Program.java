package us.supercheng.algorithm.problems.algo.permutations;

import java.util.ArrayList;
import java.util.List;

public class Program {

        public static List<List<Integer>> getPermutations_Solution1(List<Integer> array) {
            if (array == null || array.size() < 1)
                return new ArrayList<>();
            int len = array.size();
            return helper(array, new ArrayList<>(), new ArrayList<>(), len, new boolean[len]);
        }

        private static List<List<Integer>> helper(List<Integer> arr, List<List<Integer>> ret, List<Integer> list, int len, boolean[] visited) {
            if (list.size() == len) {
                ret.add(new ArrayList<>(list));
                return ret;
            }

            for (int i=0; i<len; i++) {
                if (visited[i])
                    continue;

                visited[i] = true;
                list.add(arr.get(i));

                helper(arr, ret, list, len, visited);

                list.remove(list.size() - 1);
                visited[i] = false;
            }

            return ret;
        }

    public static List<List<Integer>> getPermutations_Solution2(List<Integer> array) {
        return helper(array, new ArrayList<>(), new ArrayList<>());
    }

    private static List<List<Integer>> helper(List<Integer> arr, List<Integer> list, List<List<Integer>> ret) {
        if (arr == null || arr.isEmpty()) {
            if (!list.isEmpty())
                ret.add(new ArrayList<>(list));
        } else {
            for (int i=0, len=arr.size(); i<len; i++) {
                List<Integer> newArr = new ArrayList<>(arr);
                newArr.remove(i);

                list.add(arr.get(i));
                helper(newArr, list, ret);
                list.remove(list.size() - 1);
            }
        }

        return ret;
    }

    public static List<List<Integer>> getPermutations_Solution3(List<Integer> array) {
        return helper(array, array.size(), 0, new ArrayList<>());
    }

    private static List<List<Integer>> helper(List<Integer> arr, int len, int idx, List<List<Integer>> ret) {
        if (idx == len - 1)
            ret.add(new ArrayList<>(arr));
        else
            for (int i=idx; i<len; i++) {
                swap(arr, i, idx);

                helper(arr, len, idx + 1, ret);
                swap(arr, i, idx);
            }

        return ret;
    }

    private static void swap(List<Integer> arr, int x, int y) {
        if (x == y)
            return;
        int temp = arr.get(x);
        arr.set(x, arr.get(y));
        arr.set(y, temp);
    }
}