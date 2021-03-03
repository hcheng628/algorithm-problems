package us.supercheng.algorithm.problems.algo.underscorifysubstring;

import java.util.*;

public class Program {

    public static String underscorifySubstring(String str, String substring) {
        List<int[]> posList = getPos(str, substring);
        List<Integer> list = collapse(posList);
        return buildS(list, str);
    }

    private static String buildS(List<Integer> list, String s) {
        StringBuilder sb = new StringBuilder();
        int listIdx = 0;

        for (int sIdx = 0; sIdx < s.length(); sIdx++) {
            if (listIdx < list.size()) {
                int underscore = list.get(listIdx);
                if (underscore == sIdx) {
                    sb.append('_');
                    listIdx++;
                }
            }
            sb.append(s.charAt(sIdx));
        }

        if (listIdx < list.size() && list.get(listIdx) == s.length())
            sb.append('_');

        return sb.toString();
    }


    private static List<int[]> getPos(String s, String sub) {
        List<int[]> ret = new ArrayList<>();

        for (int i=0, len=s.length(), subLen=sub.length(); i<len; ) {
            int idx = s.indexOf(sub, i);
            if (idx < 0)
                break;

            ret.add(new int[]{idx, idx + subLen});
            i = idx + 1;
        }

        return ret;
    }

    private static List<Integer> collapse(List<int[]> list) {
        if (list.isEmpty())
            return new ArrayList<>();

        List<Integer> ret = new ArrayList<>();
        ret.add(list.get(0)[0]);
        int preEnd = list.get(0)[1];

        for (int i=1; i<list.size(); i++) {
            int currStart = list.get(i)[0];
            if (currStart > preEnd) {
                ret.add(preEnd);
                ret.add(currStart);
                preEnd = list.get(i)[1];
            } else
                preEnd = list.get(i)[1];
        }

        if (ret.size() % 2 != 0)
            ret.add(preEnd);

        return ret;
    }
}
