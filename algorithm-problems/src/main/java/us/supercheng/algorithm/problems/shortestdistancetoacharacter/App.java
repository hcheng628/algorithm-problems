package us.supercheng.algorithm.problems.shortestdistancetoacharacter;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        String S =  "loveleetcode";
        char C = 'e';
        for(int each : new App().shortestToChar1(S, C))
            PrintHelper.echo(each + " ");

        PrintHelper.echoLn("");

        for(int each : new App().shortestToChar(S, C))
            PrintHelper.echo(each + " ");
    }

    public int[] shortestToChar1(String S, char C) {
        int[] ret = new int[S.length()];
        char[] chars = S.toCharArray();
        for(int i=0;i<chars.length;i++) {
            if(chars[i] != C)
                ret[i]=getClosestC(chars, i, C);
            else
                ret[i]=0;
        }
        return ret;
    }

    private int getClosestC(char[] chars, int curr, char C) {
        boolean foundPrevC = false, foundNextC = false;
        int countP = 0, countN = 0;
        for(int i=curr;i>=0 && !foundPrevC;i--) {
            if(chars[i] == C)
                foundPrevC = true;
            else
                countP++;
        }

        for(int i=curr;i<chars.length&&!foundNextC;i++) {
            if(chars[i] == C)
                foundNextC = true;
            else
                countN++;
        }

        if(foundPrevC && foundNextC)
            return countP < countN ? countP : countN;

        if(foundPrevC)
            return countP;
        else
            return countN;
    }

    public int[] shortestToChar(String S, char C) {
        int [] ret = new int [S.length()];
        char[] chars = S.toCharArray();
        int dis = -1;

        for(int i=0;i<ret.length;i++) {
            if(chars[i] == C) {
                ret[i] = 0;
                dis = 1;
            } else
                ret[i] = dis == -1 ? ret.length : dis++;
        }

        for(int i=ret.length-1;i>=0;i--) {
            if(chars[i] == C)
                dis = 1;
            else if (ret[i] > dis)
                ret[i] = dis++;
        }
        return ret;
    }
}
