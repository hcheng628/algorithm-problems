package us.supercheng.algorithm.problems.designhashmap;

public class App {

    Integer [] values;

    /** Initialize your data structure here. */
    public App() {
        this.values = new Integer[1000001];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        this.values[key % 1000001] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Integer ret = this.values[key % 1000001];
        return ret == null ? -1 : ret;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if (this.values[key % 1000001] != null)
            this.values[key % 1000001] = null;
    }
}