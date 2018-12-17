package us.supercheng.algorithm.data.structure.tree.unionfind;

public class UF1 implements UnionFind {

    private int [] data;

    public UF1(int size) {
        this.data = new int [size];

        for(int i=0;i<this.getSize();i++)
            this.data[i] = i;
    }

    private int find(int i) {
        this.checkIndexValidation(i);
        return this.data[i];
    }

    @Override
    public int getSize() {
        return this.data.length;
    }

    @Override
    public boolean isConnected(int i, int j) {
        return this.find(i) == this.find(j);
    }

    @Override
    public void unionElements(int i, int j) {
        this.checkIndexValidation(i);
        this.checkIndexValidation(j);

        int groupIdI = this.find(i),
            groupIdJ = this.find(j);

        if(groupIdI == groupIdJ)
            return;

        for(int m=0;m<this.getSize();m++)
            if(this.data[m] == groupIdI)
                this.data[m] = groupIdJ;
    }

    private void checkIndexValidation(int i) {
        if(i < 0 || i > this.getSize()-1)
            throw new IllegalArgumentException("Error: index out of bound @ " + i);
    }
}
