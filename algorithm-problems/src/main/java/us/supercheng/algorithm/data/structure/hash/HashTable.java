package us.supercheng.algorithm.data.structure.hash;

import java.util.TreeMap;

public class HashTable <K, V> {

    private static final int LOWER_BOUND = 2;
    private static final int UPPER_BOUND = 10;
    private int capacityIndex = 0;
    private static final int[] CAPACITY = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    private int size;
    private int M;
    private TreeMap<K, V>[] hashTable;

    public HashTable() {
        this.size = 0;
        this.capacityIndex = 0;
        this.M = CAPACITY[this.capacityIndex];
        this.hashTable = new TreeMap[M];
        for(int i=0;i<this.hashTable.length;i++)
            this.hashTable[i] = new TreeMap<>();
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private int calHash(K k) {
        return k.hashCode() & 0x7fffffff % this.M;
    }

    public V remove(K k) {
        V ret = null;
        TreeMap<K,V> map = this.hashTable[this.calHash(k)];
        if(map.containsKey(k)) {
            ret = map.remove(k);
            this.size--;
            if(this.size  < LOWER_BOUND * this.M && this.capacityIndex > 0)
                this.resize(CAPACITY[--this.capacityIndex]);
        }
        return ret;
    }

    public void add(K k, V v) {
        TreeMap<K,V> map = this.hashTable[this.calHash(k)];
        if(map.containsKey(k))
            map.put(k, v);
        else {
            map.put(k, v);
            this.size++;
            if(this.size >= UPPER_BOUND * this.M && this.capacityIndex + 1 < CAPACITY.length)
                this.resize(CAPACITY[++this.capacityIndex]);
        }
    }

    public void set(K k, V v) {
        TreeMap<K,V> map = this.hashTable[this.calHash(k)];
        if(!map.containsKey(k))
            throw new RuntimeException("No such record in " + this.getClass().getSimpleName());
        map.put(k, v);
    }

    private void resize(int newM) {
        TreeMap<K, V> [] newHashTable = new TreeMap[newM];
        int oldM = this.M;
        this.M = newM;
        for(int i=0;i<this.M;i++)
            newHashTable[i] = new TreeMap<>();

        for(int i=0;i<oldM;i++) {
            TreeMap<K, V> eachTreeMap = this.hashTable[i];
            for(K key : eachTreeMap.keySet())
                newHashTable[this.calHash(key)].put(key, eachTreeMap.get(key));
        }
        this.hashTable = newHashTable;
    }

    public V get(K k) {
        return this.hashTable[this.calHash(k)].get(k);
    }

    public boolean contains(K k) {
        return this.hashTable[this.calHash(k)].containsKey(k);
    }
}