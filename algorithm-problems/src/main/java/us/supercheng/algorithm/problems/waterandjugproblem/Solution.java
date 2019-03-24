package us.supercheng.algorithm.problems.waterandjugproblem;

public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        return x==z || y == z || x + y == z
                || (x + y > z ) && z % this.gcd(x,y) == 0;
    }

    private int gcd(int a,int b) {
        return b == 0 ? a: this.gcd(b,a%b);
    }
}