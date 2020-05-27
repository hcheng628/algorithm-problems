package us.supercheng.algorithm.problems.numberofdaysbetweentwodates;

public class Solution {

    public int daysBetweenDates(String date1, String date2) {
        int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        if (date1.compareTo(date2) > 0) {
            String temp = date1;
            date1 = date2;
            date2 = temp;
        }

        int y1 = Integer.parseInt(date1.substring(0, 4)),
                y2 = Integer.parseInt(date2.substring(0, 4)),
                m1 = Integer.parseInt(date1.substring(5, 7)),
                m2 = Integer.parseInt(date2.substring(5, 7)),
                d1 = Integer.parseInt(date1.substring(8)),
                d2 = Integer.parseInt(date2.substring(8)),
                ret = 0;

        for (; y1<=y2; y1++,m1=1)
            for (; m1<=12; m1++,d1=1) {
                boolean isLeap = this.isLeap(y1);
                if (isLeap)
                    days[2]++;
                for (;d1<=days[m1];d1++) {
                    if (y1 == y2 && m1 == m2 && d1 == d2)
                        return ret;
                    ret++;
                }
                if (isLeap)
                    days[2]--;
            }

        return -1;
    }

    private boolean isLeap(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0)
                return year % 400 == 0;
            return true;
        }

        return false;
    }
}