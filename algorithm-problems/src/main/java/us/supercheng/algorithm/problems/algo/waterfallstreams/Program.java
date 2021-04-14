package us.supercheng.algorithm.problems.algo.waterfallstreams;

public class Program {

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

}
