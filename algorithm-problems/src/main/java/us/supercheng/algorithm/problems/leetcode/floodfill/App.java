package us.supercheng.algorithm.problems.leetcode.floodfill;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int [][] image = {{1,1,1},{1,1,0},{1,0,1}};
        image = new App().floodFill(image, 1, 1, 2);

        for(int i=0;i<image.length;i++) {
            for(int j=0;j<image[0].length;j++) {
                PrintHelper.echo(image[i][j] + " ");
            }
            PrintHelper.echoLn("");
        }

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        paint(image, sr, sc, newColor, color);
        for(int i=0;i<image.length;i++)
            for(int j=0;j<image[i].length;j++)
                if(image[i][j] == -newColor)
                    image[i][j] *= -1;
        return image;
    }

    private void paint(int [][] image, int row, int col, int newColor, int color) {
        if(row > image.length -1 || row < 0 || col > image[0].length -1 || col < 0)
            return;

        image[row][col] = -newColor;

        if(row + 1 <= image.length -1 && image[row+1][col] == color) {
            image[row+1][col] = -newColor;
            paint(image, row+1, col, newColor, color);
        }

        if(row -1 >= 0 && image[row-1][col] == color) {
            image[row-1][col] = -newColor;
            paint(image, row-1, col, newColor, color);
        }

        if(col + 1  <= image[0].length-1 && image[row][col + 1] == color) {
            image[row][col+1] = -newColor;
            paint(image, row, col+1, newColor, color);
        }

        if(col -1 >= 0 && image[row][col - 1] == color) {
            image[row][col-1] = -newColor;
            paint(image, row, col -1, newColor, color);
        }
    }
}