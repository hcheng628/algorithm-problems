package us.supercheng.algorithm.problems.insertdeletegetrandomo1;

import java.util.*;

class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (this.map.containsKey(val))
            return false;

        this.map.put(val, this.list.size());
        this.list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!this.map.containsKey(val))
            return false;
        /*
        for (int i=this.map.get(val);i<this.list.size()-1;i++) {
            this.list.set(i, this.list.get(i+1));
            this.map.put(this.list.get(i), this.map.get(this.list.get(i))-1);
        }
        */

        int idx = this.map.get(val), lastListIdx = this.list.size()-1;
        if (idx < lastListIdx) {
            this.map.put(this.list.get(lastListIdx), idx);
            this.list.set(idx, this.list.get(lastListIdx));
        }

        this.map.remove(val);
        this.list.remove(this.list.size()-1);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (this.list.size() < 1)
            throw new RuntimeException("Error");
        return this.list.get(this.random.nextInt(this.list.size()));
    }
}