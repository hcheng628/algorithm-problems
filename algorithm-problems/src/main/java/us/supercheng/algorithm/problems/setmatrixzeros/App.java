package us.supercheng.algorithm.problems.setmatrixzeros;

public class App {
    public void setZeroes(int[][] matrix) {
        boolean[] markRow = new boolean[matrix.length],
                markCol = new boolean[matrix[matrix.length-1].length];
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[i].length;j++)
                if(matrix[i][j] == 0) {
                    if(!markRow[i])
                        markRow[i] = true;
                    if(!markCol[j])
                        markCol[j] = true;
                }

        for(int i=0;i<markRow.length;i++)
            if(markRow[i])
                for(int j=0;j<matrix[matrix.length-1].length;j++)
                    if(matrix[i][j] != 0)
                        matrix[i][j] = 0;
        for(int i=0;i<markCol.length;i++)
            if(markCol[i])
                for(int j=0;j<matrix.length;j++)
                    if(matrix[j][i] != 0)
                        matrix[j][i] = 0;
    }
}