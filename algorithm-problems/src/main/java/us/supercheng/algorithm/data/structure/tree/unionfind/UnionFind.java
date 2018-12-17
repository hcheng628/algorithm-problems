package us.supercheng.algorithm.data.structure.tree.unionfind;

public interface UnionFind {
    int getSize();
    boolean isConnected(int a, int b);
    void unionElements(int a, int b);
}