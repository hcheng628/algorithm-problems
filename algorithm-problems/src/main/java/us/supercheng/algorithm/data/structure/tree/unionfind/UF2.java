package us.supercheng.algorithm.data.structure.tree.unionfind;

public class UF2 implements UnionFind {

    private int [] parent;


    public UF2(int size) {
        this.parent = new int [size];

        for(int i=0;i<this.getSize();i++)
            this.parent[i] = i;
    }

    @Override
    public int getSize() {
        return this.parent.length;
    }

    @Override
    public boolean isConnected(int a, int b) {
        this.checkIndexValidation(a);
        this.checkIndexValidation(b);
        return this.parent[a] == this.parent[b] || this.find(a) == find(b);
    }

    @Override
    public void unionElements(int a, int b) {
        this.checkIndexValidation(a);
        this.checkIndexValidation(b);
        this.parent[a] = this.parent[b];
    }

    private int find(int i) {
        this.checkIndexValidation(i);
        while(i != this.parent[i])
            i = this.parent[i];
        return i;
    }

    private void checkIndexValidation(int i) {
        if(i < 0 || i > this.getSize()-1)
            throw new IllegalArgumentException("Error: index out of bound @ " + i);
    }
}