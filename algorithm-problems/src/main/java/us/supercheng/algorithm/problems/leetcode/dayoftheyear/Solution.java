package us.supercheng.algorithm.problems.leetcode.dayoftheyear;

class Solution {

    public int dayOfYear(String date) {

        int[] monthMap = {0,
                31, 28, 31,
                30, 31, 30,
                31, 31, 30,
                31, 30, 31};
        String[] dateArr = date.split("-");
        int year = Integer.parseInt(dateArr[0]),
                month = Integer.parseInt(dateArr[1]),
                day = Integer.parseInt(dateArr[2]),
                ret = 0;

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
            monthMap[2]++;

        for (int i=1;i<month;i++)
            ret += monthMap[i];

        return ret+day;
    }
}