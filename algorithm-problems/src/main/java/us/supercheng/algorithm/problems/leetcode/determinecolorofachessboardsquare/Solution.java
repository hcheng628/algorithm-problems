package us.supercheng.algorithm.problems.leetcode.determinecolorofachessboardsquare;

public class Solution {

    public boolean squareIsWhite(String coordinates) {
        int row = coordinates.charAt(1) - '1';
        int col = coordinates.charAt(0) - 'a';
        return !(row % 2 == col % 2);
    }

}
