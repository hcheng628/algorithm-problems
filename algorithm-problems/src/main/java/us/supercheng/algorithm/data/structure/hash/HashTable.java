package us.supercheng.algorithm.data.structure.hash;

import java.util.TreeMap;

public class HashTable <K, V> {
    private int size;
    private int M;
    private TreeMap<K, V>[] hashTable;

    public HashTable(int M) {
        this.size = 0;
        if(M < 0)
            this.M = 97;
        this.M = M;
        this.hashTable = new TreeMap[M];
        for(int i=0;i<this.hashTable.length;i++)
            this.hashTable[i] = new TreeMap<>();
    }

    public HashTable() {
        this(97);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int calHash(K k) {
        return k.hashCode() & 0x7fffffff % this.M;
    }

    public V remove(K k) {
        V ret = null;
        TreeMap<K,V> map = this.hashTable[this.calHash(k)];
        if(map.containsKey(k)) {
            ret = map.remove(k);
            this.size--;
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
        }
    }

    public void set(K k, V v) {
        TreeMap<K,V> map = this.hashTable[this.calHash(k)];
        if(!map.containsKey(k))
            throw new RuntimeException("No such record in " + this.getClass().getSimpleName());
        map.put(k, v);
    }

    public V get(K k) {
        return this.hashTable[this.calHash(k)].get(k);
    }

    public boolean contains(K k) {
        return this.hashTable[this.calHash(k)].containsKey(k);
    }
}