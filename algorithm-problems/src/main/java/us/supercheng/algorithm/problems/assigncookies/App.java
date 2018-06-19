package us.supercheng.algorithm.problems.assigncookies;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Arrays;

public class App {

    public static void main(String [] args) {
        App app = new App();
        int [] kids = {13,3,9,3,6,9,6};
        int [] cookies = {33,15,1,3,4,5};
        PrintHelper.echoLn(app.findContentChildren(kids, cookies));
    }

    public int findContentChildren(int[] g, int[] s) {
        if(g == null || s == null || g.length < 1 || s.length < 1)
            return 0;
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int pointerP = 0;
        int pointerC = 0;
        while(pointerP<g.length && pointerC < s.length) {
            if(s[pointerC] >= g[pointerP]) {
                pointerC++;
                pointerP++;
                count++;
            } else
                pointerC++;
        }
        return count;
    }
}