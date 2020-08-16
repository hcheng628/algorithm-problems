package us.supercheng.algorithm.problems.destinationcity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();

        for (List<String> l : paths)
            map.put(l.get(0), l.get(1));

        return this.travel(map, paths.get(0).get(0));
    }

    private String travel(Map<String, String> map, String from) {
        return map.containsKey(from) ? this.travel(map, map.get(from)) : from;
    }

}
