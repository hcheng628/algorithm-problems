package us.supercheng.algorithm.problems.rotateimage;

public class App {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++)
            for(int left =0, right = matrix.length-1;left<right;left++,right--)
                this.swap(matrix, i, left, i, right);

        for(int i=0, count = 0;i<matrix.length-1;i++, count++) {
            boolean flag = false;
            for(int j=matrix[i].length-1-count,swapCount = 1;j>=0;j--) {
                if(!flag) {
                    flag = true;
                    continue;
                }
                this.swap(matrix, i, j, i+swapCount, j+swapCount);
                swapCount++;
            }
        }
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }
}