package us.supercheng.algorithm.problems.maximizedistancetoclosestperson;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int[] seats = {1,0,0,0,1,0,1};
        PrintHelper.echoLn(new App().maxDistToClosest(seats));
    }

    public int maxDistToClosest(int[] seats) {
        int ret = Integer.MIN_VALUE;
        for(int i=0;i<seats.length;i++) {
            if(seats[i] != 1) {
                int res;
                if(i == 0)
                    res = this.checkNext(seats, i);
                else if (i == seats.length-1)
                    res = this.checkPrev(seats, i);
                else
                    res = Math.min(this.checkPrev(seats, i), this.checkNext(seats, i));
                if(res > ret)
                    ret = res;
            }
        }
        return ret;
    }

    private int checkPrev(int[] seats, int index) {
        int ret = 1;
        for(int i=index-1;i>=0; i--, ret++)
            if(seats[i] == 1)
                return ret;
        return ret;
    }

    private int checkNext(int[] seats, int index) {
        int ret = 1;
        for(int i=index+1;i<seats.length; i++, ret++)
            if(seats[i] == 1)
                return ret;
        return ret;
    }

}