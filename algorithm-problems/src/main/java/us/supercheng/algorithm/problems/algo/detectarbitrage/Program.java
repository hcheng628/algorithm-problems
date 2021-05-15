package us.supercheng.algorithm.problems.algo.detectarbitrage;

import java.util.*;

public class Program {

    // Time: O(n^2) Space: O(n^2)
    public boolean detectArbitrage(ArrayList<ArrayList<Double>> exchangeRates) {
        int size = exchangeRates.size();
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();

        for (int i=0; i<size; i++) {
            if (!map.containsKey(i))
                map.put(i, new HashMap<>());
            Map<Integer, Double> subMap = map.get(i);
            for (int j=0; j<size; j++)
                subMap.put(j, exchangeRates.get(i).get(j));
        }

        for (int i=0; i<size; i++)
            if (this.travel(map, size, new HashSet<>(), i, i, 1.0))
                return true;

        return false;
    }

    private boolean travel(Map<Integer, Map<Integer, Double>> map, int size, Set<Integer> visited, int from, int curr, double amt) {
        if (amt * map.get(curr).get(from) - 1 > 0)
            return true;

        if (visited.contains(curr))
            return false;
        visited.add(curr);

        for (int to=0; to<size; to++)
            if (this.travel(map, size, visited, from, to, amt * map.get(curr).get(to)))
                return true;

        return false;
    }

}
