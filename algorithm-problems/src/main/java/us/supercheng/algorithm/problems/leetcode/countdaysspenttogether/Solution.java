package us.supercheng.algorithm.problems.leetcode.countdaysspenttogether;

class Solution {

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String arrive = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
        String leave = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;

        if (arrive.compareTo(leave) > 0)
            return 0;

        int arriveMonth = Integer.parseInt(arrive.substring(0, 2));
        int leaveMonth = Integer.parseInt(leave.substring(0, 2));
        int arriveDate = Integer.parseInt(arrive.substring(3));
        int leaveDate = Integer.parseInt(leave.substring(3));
        if (arriveMonth == leaveMonth)
            return leaveDate - arriveDate + 1;

        final int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ret = 0;
        for (int i = arriveMonth + 1; i < leaveMonth; i++)
            ret += days[i - 1];

        return (days[arriveMonth - 1] - arriveDate + 1) + ret + leaveDate;
    }

}
