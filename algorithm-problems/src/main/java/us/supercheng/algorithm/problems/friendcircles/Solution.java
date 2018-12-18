package us.supercheng.algorithm.problems.friendcircles;

class Solution {

    private int [] parent;
    private int [] rank;

    public int findCircleNum(int[][] M) {
        this.parent = new int [M.length];
        this.rank = new int [M.length];

        for(int i=0;i<this.parent.length;i++)
            this.parent[i] = i;

        for(int i=0;i<M.length;i++)
            for(int j=i+1;j<M[0].length;j++)
                if(M[i][j] == 1)
                    this.makeFriend(i, j);

        int ret = 0;
        for(int i=0;i<this.parent.length;i++)
            if(this.parent[i] == i)
                ret++;
        return ret;
    }

    private void makeFriend(int a, int b) {
        int rootA = this.findParent(a),
                rootB = this.findParent(b);
        if(rootA == rootB)
            return;

        if(this.rank[rootA] > this.rank[rootB])
            this.parent[rootB] = rootA;
        else if(this.rank[rootA] < this.rank[rootB])
            this.parent[rootA]= rootB;
        else {
            this.parent[rootA] = rootB;
            this.rank[rootB]++;
        }
    }

    private int findParent(int i) {
        while(this.parent[i]!=i)
            i = this.parent[i];
        return i;
    }
}