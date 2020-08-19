package us.supercheng.algorithm.problems.lrucache;

import java.util.*;

public class LRUCache {

    private int cap;
    private List<Integer> list;
    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        int ret = -1;

        if (this.map.containsKey(key)) {
            ret = this.map.get(key);
            this.list.remove(this.list.indexOf(key));   // optimize
            this.list.add(key);
        }

        return ret;
    }

    public void put(int key, int value) {
        if (this.map.containsKey(key))
            this.list.remove(this.list.indexOf(key));  // optimize
        else
        if (this.list.size() + 1 > this.cap)
            this.map.remove(this.list.remove(0));

        this.list.add(key);
        this.map.put(key, value);
    }
}