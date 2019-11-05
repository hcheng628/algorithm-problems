package us.supercheng.algorithm.problems.mapsumpairs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MapSum {

    Map<String, Integer> masterMap;
    Map<String, Set<String>> map;

    public MapSum() {
        this.masterMap = new HashMap<>();
        this.map = new HashMap<>();
    }

    public void insert(String key, int val) {
        if (this.masterMap.containsKey(key) && this.masterMap.get(key) != val)
            this.masterMap.put(key, val);
        else {
            this.masterMap.put(key, val);
            Set<String> set = new HashSet<>();
            for (int i=1, len=key.length()+1;i<len;i++)
                set.add(key.substring(0, i));
            this.map.put(key, set);
        }
    }

    public int sum(String prefix) {
        int ret = 0;
        for (String key : this.masterMap.keySet())
            if (this.map.get(key).contains(prefix))
                ret += this.masterMap.get(key);
        return ret;
    }
}