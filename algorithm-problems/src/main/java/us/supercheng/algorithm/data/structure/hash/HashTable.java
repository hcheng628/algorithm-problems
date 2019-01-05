package us.supercheng.algorithm.data.structure.hash;

import us.supercheng.algorithm.common.helper.PrintHelper;

import java.util.TreeMap;

public class HashTable <K, V> {

    private static final int LOWER_BOUND = 2;
    private static final int UPPER_BOUND = 10;
    private static final int INIT_CAPACITY = 97;

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
        this(INIT_CAPACITY);
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
            if(this.size  < LOWER_BOUND * this.M && this.M / 2 >= INIT_CAPACITY)
                this.resize(this.M / 2);
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
            if(this.size >= UPPER_BOUND * this.M) {
                this.resize(this.M * 2);
            }
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