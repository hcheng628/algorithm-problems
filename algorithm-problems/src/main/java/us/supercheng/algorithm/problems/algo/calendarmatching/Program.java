package us.supercheng.algorithm.problems.algo.calendarmatching;

import java.util.*;

public class Program {

    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {
        boolean[][] myTable = buildTable(calendar1, dailyBounds1);
        boolean[][] herTable = buildTable(calendar2, dailyBounds2);
        return generateMeetings(myTable, herTable, meetingDuration);
    }


    private static List<StringMeeting> generateMeetings(boolean[][] myTable, boolean[][] herTable, int duration) {
        List<StringMeeting> ret = new ArrayList<>();

        for (int i=0; i<24; i++)
            for (int j=0; j<60; j++)
                if (!myTable[i][j] && !herTable[i][j]) {
                    int count = 1;
                    int[] time = new int[]{i, j};

                    for (; !myTable[time[0]][time[1]] && !herTable[time[0]][time[1]] && time[0] < 24; incrementT(time))
                        count++;

                    if (count >= duration)
                        ret.add(new StringMeeting(i + ":" + getTime(j), time[0] + ":" + getTime(time[1])));

                    i = time[0];
                    j = time[1];
                }

        return ret;
    }

    private static String getTime(int t) {
        return t < 10 ? "0" + t : Integer.toString(t);
    }

    private static boolean[][] buildTable(List<StringMeeting> cals, StringMeeting bound) {
        boolean[][] ret = new boolean[24][60];

        for (StringMeeting meeting : cals)
            updateTable(ret, meeting, false);

        StringMeeting notAvailableBeforeWork = new StringMeeting("0:00", bound.start);
        updateTable(ret, notAvailableBeforeWork, false);
        StringMeeting notAvailableAfterWork = new StringMeeting(bound.end, "23:59");
        updateTable(ret, notAvailableAfterWork, true);

        return ret;
    }

    private static void updateTable(boolean[][] table, StringMeeting stringMeeting, boolean updateEnd) {
        int[] idx = toIdx(stringMeeting.start);
        int[] endIdx = toIdx(stringMeeting.end);

        if (updateEnd)
            table[endIdx[0]][endIdx[1]] = true;

        for (; !(idx[0] == endIdx[0] && idx[1] == endIdx[1]); incrementT(idx))
            table[idx[0]][idx[1]] = true;
    }

    private static void incrementT(int[] curr) {
        if (curr[1] < 59)
            curr[1]++;
        else {
            curr[1] = 0;
            curr[0]++;
        }
    }

    private static int[] toIdx(String time) {
        String[] t = time.split(":");
        return new int[]{Integer.parseInt(t[0]), Integer.parseInt(t[1])};
    }

    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }
}
