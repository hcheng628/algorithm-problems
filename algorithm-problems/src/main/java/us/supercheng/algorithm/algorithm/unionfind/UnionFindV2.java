package us.supercheng.algorithm.algorithm.unionfind;

import us.supercheng.algorithm.common.helper.PrintHelper;
import us.supercheng.algorithm.data.structure.tree.unionfind.UnionFind;

public class UnionFindV2 {

    private int [] parent;
    private int [] rank;
    private int size;

    public UnionFindV2(int size) {
        this.size = size;
        this.parent = new int[this.size];
        this.rank = new int[this.size];
        for(int i=0;i<this.size;i++)
            this.parent[i] = i;
    }

    public void unionElements(int a, int b) {
        int parentAId = this.findParent(a),
                parentBId = this.findParent(b);
        if(parentAId == parentBId)
            return;

        if(this.rank[parentAId] < this.rank[parentBId])
            this.parent[parentAId] = parentBId;
        else if(this.rank[parentAId] > this.rank[parentBId])
            this.parent[parentBId] = parentAId;
         else {
            this.parent[parentAId] = parentBId;
            this.rank[parentAId]++;
        }
    }

    public boolean isConnected(int a, int b) {
        return a != b ? this.findParent(a) == this.findParent(b) : true;
    }

    private int findParent(int id) {
        if(id != this.parent[id]) {
            //this.parent[id] = this.findParent(this.parent[id]);
            //return this.parent[id];
            return this.findParent(this.parent[id]);
        }
        return id;
    }

    public void debug() {
        for(int i=0;i<this.size;i++) {
            PrintHelper.echo(i + ", ");
        }
        PrintHelper.echoLn("");

        for(int i=0;i<this.size;i++) {
            PrintHelper.echo(this.parent[i] + ", ");
        }
        PrintHelper.echoLn("");


        for(int i=0;i<this.size;i++) {
            PrintHelper.echo(this.rank[i] + ", ");
        }
        PrintHelper.echoLn("");

    }

    public static void main(String[] args){
        int n = 10000;
        UnionFindV2 uf = new UnionFindV2(10);

        uf.unionElements(0, 1);
        uf.unionElements(0, 2);
        uf.unionElements(0, 3);
        uf.unionElements(0, 4);

        uf.unionElements(5, 6);
        uf.unionElements(5, 7);
        uf.unionElements(5, 8);
        uf.unionElements(5, 9);

        uf.debug();

        /*
        UnionFindV2 uf = new UnionFindV2(n);
        long startTime = System.currentTimeMillis();
        for( int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            uf.unionElements(a,b);
        }
        // 再进行n次操作, 每次随机选择两个元素, 查询他们是否同属一个集合
        for(int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            uf.isConnected(a,b);
        }
        long endTime = System.currentTimeMillis();
        PrintHelper.echoLn("UnionFindV2, " + 2 * n + " ops, " + (endTime-startTime) + "ms");
        */
    }
}