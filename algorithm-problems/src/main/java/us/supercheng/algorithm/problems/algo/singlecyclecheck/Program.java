package us.supercheng.algorithm.problems.algo.singlecyclecheck;

import java.util.*;

public class Program {

    private static int getNext(int[] arr, int len, int curr, int amt) {
        int idx = (curr + amt) % len;
        return idx >= 0 ? idx : len + idx;
    }

    public static boolean hasSingleCycle_Solution1(int[] array) {
        for (int i=0, len = array.length; i<len; i++) {
            boolean[] visited = new boolean[len];
            travel(array, i, visited);
            for (boolean v : visited)
                if (!v)
                    return false;
        }

        return true;
    }

    private static void travel(int[] arr, int idx, boolean[] visited) {
        if (visited[idx])
            return;

        visited[idx] = true;

        if (arr[idx] == 0)
            return;

        travel(arr, getNext(arr, arr.length, idx, arr[idx]), visited);
    }


    public static boolean hasSingleCycle_Solution2(int[] array) {
        return travel(array, array.length, 0, 0);
    }

    private static boolean travel(int[] arr, int len, int idx, int count) {
        if (count == len)
            return idx == 0;
        else if (count !=0 && idx == 0)
            return false;

        return travel(arr, len, getNext(arr, len, idx, arr[idx]), count + 1);
    }


    public static boolean hasSingleCycle_Solution3(int[] array) {
        int curr=0;

        for (int count=0, len=array.length; count<len; count++) {
            if (count != 0 && curr == 0)
                return false;
            curr = getNext(array, len, curr, array[curr]);
        }

        return curr == 0;
    }
}

