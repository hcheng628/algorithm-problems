package us.supercheng.algorithm.problems.algo.waterfallstreams;

public class Program {

    // Time: O(m*n) Space: O(m)
    public double[] waterfallStreams(double[][] array, int source) {
        double[] ret = new double[array[0].length];
        this.travel(array, 1.0, 'd', 0, source, ret);
        return ret;
    }

    private void travel(double[][] arr, double amt, char dir, int x, int y, double[] ret) {
        if (y < 0 || y >= arr[0].length || arr[x][y] == 1) // out of range or on a block
            return;

        if (x == arr.length - 1) {
            ret[y] += amt * 100;
            return;
        }

        if (dir == 'd')
            if (arr[x+1][y] == 1) { // Split
                this.travel(arr, amt/2, 'l', x, y - 1, ret);
                this.travel(arr, amt/2, 'r', x, y + 1, ret);
            } else
                this.travel(arr, amt, 'd', x + 1, y, ret);
        else if (dir == 'l')
            if (arr[x+1][y] == 1)
                this.travel(arr, amt, 'l', x, y - 1, ret);
            else
                this.travel(arr, amt, 'd', x + 1, y, ret);
        else
            if (arr[x+1][y] == 1)
                this.travel(arr, amt, 'r', x, y + 1, ret);
            else
                this.travel(arr, amt, 'd', x + 1, y, ret);
    }


    // Time: O(m^2*n) Space: O(m*n)
    public double[] waterfallStreams_Solution2(double[][] array, int source) {
        double[][] water = new double[array.length][array[0].length];
        water[0][source] = -1.0;

        for (int i=1; i<array.length; i++) {
            for (int j=0; j<array[0].length; j++) {
                if (array[i][j] == 1) {
                    if (water[i - 1][j] < 0) {
                        int left = this.getAvailableIdx(array, i, j, -1);
                        int right = this.getAvailableIdx(array, i, j, 1);
                        double splitVal = water[i-1][j] / 2;

                        if (left != -1)
                            water[i][left] += splitVal;

                        if (right != -1)
                            water[i][right] += splitVal;
                    }
                } else
                    water[i][j] += water[i - 1][j];
            }
        }

        for (int i=0, rowIdx=water.length - 1; i<array[0].length; i++)
            water[rowIdx][i] *= -100;

        return water[water.length - 1];
    }

    private int getAvailableIdx(double[][] arr, int row, int col, int amt) {
        for (;(col > -1 && amt < 0) || (col < arr[0].length && amt > 0); col += amt) {
            if (arr[row - 1][col] == 1)
                break;

            if (arr[row][col] != 1)
                return col;
        }

        return -1;
    }

}
