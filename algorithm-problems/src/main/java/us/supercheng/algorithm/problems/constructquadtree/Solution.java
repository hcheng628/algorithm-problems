package us.supercheng.algorithm.problems.constructquadtree;

public class Solution {

    public Node construct(int[][] grid) {
        Node ret = new Node();
        int len = grid.length,
                halfLen = len/2;
        int[] res = this.valCount(grid, len);

        if (res[1] != 0)
            ret.val = true;

        if (res[0] == 0 || res[1] == 0)
            ret.isLeaf = true;

        if (res[0] != 0 && res[1] != 0) {
            ret.topLeft = this.construct(this.buildG(grid, halfLen, 0, 0));
            ret.topRight = this.construct(this.buildG(grid, halfLen, 0, halfLen));
            ret.bottomLeft = this.construct(this.buildG(grid, halfLen, halfLen, 0));
            ret.bottomRight = this.construct(this.buildG(grid, halfLen, halfLen, halfLen));
        }

        return ret;
    }

    private int[][] buildG(int[][] g, int size, int offR, int offC) {
        int[][] ret = new int[size][size];
        for (int i=0; i<size; i++)
            for (int j=0; j<size;j++)
                ret[i][j] = g[offR+i][offC+j];
        return ret;
    }

    private int[] valCount(int[][] g, int len) {
        int[] ret = new int[2];
        for (int i=0; i<len; i++)
            for (int j=0; j<len; j++) {
                ret[g[i][j]]++;
                if (ret[0] > 1 && ret[1] > 1)
                    return ret;
            }

        return ret;
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}