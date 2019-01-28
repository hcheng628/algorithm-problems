package us.supercheng.algorithm.problems.rectanglearea;

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int totalArea = (C - A) * (D - B) + (G - E) * (H - F);
        return (A >= G || C <= E || B >= H || D <= F) ? totalArea :
                totalArea - (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
    }
}