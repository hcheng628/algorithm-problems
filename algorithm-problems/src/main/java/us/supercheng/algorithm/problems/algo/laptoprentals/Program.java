package us.supercheng.algorithm.problems.algo.laptoprentals;

import java.util.*;

public class Program {

    public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
        int ret = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (List<Integer> time : times)
            for (int i=time.get(0), len=time.get(1); i<len; i++) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                ret = Math.max(map.get(i), ret);
            }

        return ret;
    }

}
