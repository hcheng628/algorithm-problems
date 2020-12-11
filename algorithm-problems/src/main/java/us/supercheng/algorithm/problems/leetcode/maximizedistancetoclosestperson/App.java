package us.supercheng.algorithm.problems.leetcode.maximizedistancetoclosestperson;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        int[] seats = {1,0,0,0,1,0,1};
        PrintHelper.echoLn(new App().maxDistToClosest(seats));
        PrintHelper.echoLn(new App().maxDistToClosest1(seats));
        PrintHelper.echoLn(new App().maxDistToClosest2(seats));
    }

    public int maxDistToClosest(int[] seats) {
        int ret = Integer.MIN_VALUE, curr = Integer.MIN_VALUE;
        for (int i=0;i<seats.length;i++) {
            if(seats[i] == 1) {
                ret = Math.max(ret, curr == Integer.MIN_VALUE ? i : (i - curr) / 2);
                curr = i;
            }
        }
        int res = seats.length - 1 - curr;
        return res > ret ? res : ret;
    }

    public int maxDistToClosest1(int[] seats) {
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

    public int maxDistToClosest2(int[] seats) {
        int ret = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<seats.length;i++)
            if(seats[i] ==1)
                list.add(i);

        if(seats[0] == 0) {
            int border = list.get(0) - 0;
            if(border > ret)
                ret = border;
        }

        if(seats[seats.length-1]==0) {
            int border = seats.length - 1 - list.get(list.size()-1);
            if(border > ret)
                ret = border;
        }

        for(int i=0;i<list.size()-1;i++) {
            int res = (list.get(i+1) - list.get(i)) / 2;
            if(res > ret)
                ret = res;
        }
        return ret;
    }
}