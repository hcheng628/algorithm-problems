package us.supercheng.algorithm.problems.distringmatch;

public class App {
    public int[] diStringMatch(String S) {
        int max = S.length(),
                min = 0,
                len = max;
        int [] ret = new int [max+1];

        for(int i=0;i<len;i++) {
            char each = S.charAt(i);
            if(each == 'I')
                ret[i] = min++;
            else
                ret[i] = max--;
        }
        
        ret[ret.length-1] = min;

        return ret;
    }
}