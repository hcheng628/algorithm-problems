package us.supercheng.algorithm.problems.transposematrix;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int [][] A = {{1,2,3},{4,5,6},{7,8,9}};

        for(int[] AA : new App().transpose(A)) {
            PrintHelper.echo("[ ");
            for(int AAA : AA)
                PrintHelper.echo(AAA + " ");
            PrintHelper.echo("]");
            PrintHelper.echoLn("");
        }
    }

    public int[][] transpose(int[][] A) {
        int [][] ret = new int [A[0].length][A.length];
        for(int i=0;i<ret.length;i++)
            for(int j=0;j<A.length;j++)
                ret[i][j] = A[j][i];
        return ret;
    }
}
