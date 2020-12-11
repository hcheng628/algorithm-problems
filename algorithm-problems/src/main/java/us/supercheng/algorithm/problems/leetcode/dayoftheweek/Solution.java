package us.supercheng.algorithm.problems.leetcode.dayoftheweek;

class Solution {

    public String dayOfTheWeek(int day, int month, int year) {
        // 1971 1 1 => Friday
        String[] ARR_D = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] ARR_M = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;

        for (int y=1970;y<year;y++)
            days += 365 + this.isLeapYr(y);

        for (int i=1;i<month;i++)
            days += i == 2 ? ARR_M[i-1] + this.isLeapYr(year) : ARR_M[i-1];

        return ARR_D[(days + day + 3) % 7];
    }

    private int isLeapYr(int yr) {
        return (yr % 4 == 0 && yr % 100 != 0) || yr % 400 == 0 ? 1 : 0;
    }
}