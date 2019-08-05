package us.supercheng.algorithm.problems.randompickwithweight;

import java.util.Random;
import java.util.TreeMap;

class Solution {

    TreeMap<Double, Integer> map;
    Random rand;
    double sum;

    public Solution(int[] w) {
        this.map = new TreeMap<>();
        this.rand = new Random();
        this.sum = 0;
        int len = w.length;

        for (int i=0;i<len;i++) {
            this.map.put(sum, i);
            sum += w[i] * len;
        }
    }

    public int pickIndex() {
        double key = this.sum * this.rand.nextDouble();
        Integer ret = map.get(key);
        return ret != null ? ret : map.get(map.lowerKey(key));
    }
}