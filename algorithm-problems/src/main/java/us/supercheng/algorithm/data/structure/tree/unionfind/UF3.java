package us.supercheng.algorithm.data.structure.tree.unionfind;

public class UF3 implements UnionFind {

    private int [] parent;
    private int [] sz;


    public UF3(int size) {
        this.parent = new int [size];
        this.sz = new int [size];

        for(int i=0;i<this.getSize();i++) {
            this.parent[i] = i;
            this.sz[i] = 1;
        }

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

        int aRoot = this.find(a),
            bRoot = this.find(b);

        if(aRoot == bRoot)
            return;

        if(this.sz[aRoot] > this.sz[bRoot]) {
            this.parent[bRoot] = aRoot;
            this.sz[aRoot] += this.sz[bRoot];
        } else {
            this.parent[aRoot] = bRoot;
            this.sz[bRoot] += this.sz[aRoot];
        }
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