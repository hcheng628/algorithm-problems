package us.supercheng.algorithm.problems.uniquepathsii;

public class App {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for(int i=0;i<obstacleGrid.length;i++)
            for(int j=0;j<obstacleGrid[i].length;j++) {
                if(i == 0) {
                    if(j-1 >= 0 && obstacleGrid[i][j-1] == -1)
                        obstacleGrid[i][j] = -1;
                    else
                        obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? -1 : 1;
                } else if (j == 0) {
                    if(i-1 >= 0 && obstacleGrid[i-1][j] == -1)
                        obstacleGrid[i][j] = -1;
                    else
                        obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? -1 : 1;
                } else
                    obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? -1 : (obstacleGrid[i-1][j] == -1 ? 0 : obstacleGrid[i-1][j]) + (obstacleGrid[i][j-1] == -1 ? 0 : obstacleGrid[i][j-1]);
            }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[obstacleGrid.length-1].length-1] == -1 ? 0 : obstacleGrid[obstacleGrid.length-1][obstacleGrid[obstacleGrid.length-1].length-1];
    }
}
