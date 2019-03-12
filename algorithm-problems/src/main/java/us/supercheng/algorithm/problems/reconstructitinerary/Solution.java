package us.supercheng.algorithm.problems.reconstructitinerary;

import java.util.*;

class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> ret = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i=0;i<tickets.length;i++)
            if(map.containsKey(tickets[i][0]))
                map.get(tickets[i][0]).add(tickets[i][1]);
            else {
                List<String> list = new ArrayList<>();
                list.add(tickets[i][1]);
                map.put(tickets[i][0], list);
            }


        for (String city : map.keySet())
            Collections.sort(map.get(city));

        ret.add("JFK");
        this.dfs("JFK", ret, map, tickets.length);
        return ret;
    }


    private void dfs(String from, List<String> ret, Map<String, List<String>> map, int total) {
        if ((ret.size() >  total) || (map.get(from) == null || map.get(from).size() == 0))
            return;

        for (int i=0;i<map.get(from).size();i++) {
            ret.add(map.get(from).get(i));
            String next = map.get(from).remove(i);
            this.dfs(next, ret, map, total);
            if (ret.size() > total)
                return;
            ret.remove(ret.size()-1);
            map.get(from).add(i, next);
        }
    }
}