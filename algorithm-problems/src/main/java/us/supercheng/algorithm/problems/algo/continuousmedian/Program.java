package us.supercheng.algorithm.problems.algo.continuousmedian;

import java.util.*;

public class Program {

    static class ContinuousMedianHandler {
        double median = 0;

        List<Integer> list = new ArrayList<>();

        public void insert(int number) {
            int idx = Collections.binarySearch(list, number);

            if (idx < 0)
                idx = Math.abs(idx + 1);

            list.add(idx, number);

            int size = list.size();
            idx = size / 2;
            median = size % 2 == 0 ? (list.get(idx - 1) + list.get(idx)) / 2.0 : list.get(idx);
        }

        public double getMedian() {
            return median;
        }
    }
}

