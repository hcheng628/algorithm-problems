package us.supercheng.algorithm.problems.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<>();
        if(intervals == null || intervals.size() == 0)
            return ret;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        ret.add(intervals.get(0));
        if(intervals.size() == 1)
            return ret;

        for(int i=1;i<intervals.size();i++) {
            Interval each = intervals.get(i), retLast = ret.get(ret.size()-1);
            if(retLast.end < each.start)
                ret.add(each);
            else if(retLast.end >= each.start && retLast.end < each.end)
                retLast.end = each.end;
        }
        return ret;
    }
}
