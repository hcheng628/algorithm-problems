package us.supercheng.algorithm.problems.expressivewords;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    class Segment {
        char c;
        int num;

        public Segment(char c) {
            this.c = c;
            this.num = 1;
        }
    }

    public int expressiveWords(String S, String[] words) {
        int ret = 0;

        List<Segment> list = this.buildSegment(S);
        for (String w : words) {
            List<Segment> currList = this.buildSegment(w);
            if (this.check(list, currList)) {
                ret++;
            }
        }

        return ret;
    }

    private List<Segment> buildSegment(String s) {
        if (s== null || s.length() < 1)
            return new ArrayList<>();

        List<Segment> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        Segment seg = new Segment(chars[0]);

        for (int i=1;i<chars.length;i++)
            if (chars[i-1] != chars[i]) {
                list.add(seg);
                seg = new Segment(chars[i]);
            } else
                seg.num++;

        list.add(seg);
        return list;
    }

    private boolean check(List<Segment> list, List<Segment> currList) {
        if (list.size() != currList.size())
            return false;

        for (int i=0;i<list.size();i++) {
            Segment segL = list.get(i),
                    segCurr = currList.get(i);
            if (segL.c != segCurr.c || segCurr.num > segL.num || (segL.num < 3 && segL.num != segCurr.num) )
                return false;
        }

        return true;
    }
}