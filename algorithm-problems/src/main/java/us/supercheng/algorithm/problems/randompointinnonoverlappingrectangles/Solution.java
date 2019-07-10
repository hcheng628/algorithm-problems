package us.supercheng.algorithm.problems.randompointinnonoverlappingrectangles;

import java.util.Random;
import java.util.TreeMap;

class Solution {

    private Random rand;
    private int areaTotal;
    private int [][] RECTS;
    private TreeMap<Integer, int[]> map;

    public Solution(int[][] rects) {
        if (rects == null || rects.length < 1 || rects[0] == null || rects[0].length < 1)
            throw new IllegalArgumentException("Give me some valid data!");

        this.areaTotal = 0;
        this.RECTS = rects;
        this.rand = new Random();
        this.map = new TreeMap<>();

        for (int i=0;i<this.RECTS.length;i++) {
            this.map.put(this.areaTotal, this.RECTS[i]);
            this.areaTotal += (this.RECTS[i][2] - this.RECTS[i][0] + 1) * (this.RECTS[i][3] - this.RECTS[i][1] + 1);
        }
    }

    public int[] pick() {
        int[] rect = this.map.get(this.map.floorKey(this.rand.nextInt(areaTotal)));
        return new int[] {this.rand.nextInt(rect[2]-rect[0]+1) + rect[0],
                this.rand.nextInt(rect[3]-rect[1]+1) + rect[1]};
    }
}
