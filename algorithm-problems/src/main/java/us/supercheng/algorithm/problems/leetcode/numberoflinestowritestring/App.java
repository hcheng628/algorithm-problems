package us.supercheng.algorithm.problems.leetcode.numberoflinestowritestring;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int [] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String S =  "bbbcccdddaaa";
        int [] res = new App().numberOfLines(widths, S);
        PrintHelper.echoLn("Total Rows: " + res[0] + " Total Cols: " + res[1]);
    }

    public int[] numberOfLines(int[] widths, String S) {
        int row=1,col=0;
        char[] chars = S.toCharArray();
        for (int i=0;i<chars.length;i++) {
            if (col + widths[chars[i] - 97] <= 100)
                col += widths[chars[i] - 97];
            else {
                row++;
                col = widths[chars[i] - 97];
            }
        }
        int [] ret = {row, col};
        return ret;
    }
}