package us.supercheng.algorithm.data.structure.tree.unionfind;

public class UF5 implements UnionFind {

    private int [] parent;
    private int [] rank;


    public UF5(int size) {
        this.parent = new int [size];
        this.rank = new int [size];

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

        int aRoot = this.find(a),
            bRoot = this.find(b);

        if(aRoot == bRoot)
            return;

        if(this.rank[aRoot] > this.rank[bRoot])
            this.parent[bRoot] = aRoot;
        else if (this.rank[aRoot] < this.rank[bRoot])
            this.parent[aRoot] = bRoot;
        else {
            this.parent[aRoot] = bRoot;
            this.rank[bRoot]++;
        }
    }


    private int find(int i) {
        this.checkIndexValidation(i);
        while(i != this.parent[i]) {
            this.parent[i] = this.parent[this.parent[i]];
            i = this.parent[i];
        }
        return i;
    }

    private void checkIndexValidation(int i) {
        if(i < 0 || i > this.getSize()-1)
            throw new IllegalArgumentException("Error: index out of bound @ " + i);
    }
}