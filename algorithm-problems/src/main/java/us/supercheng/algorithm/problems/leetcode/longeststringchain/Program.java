package us.supercheng.algorithm.problems.leetcode.longeststringchain;

import java.util.*;


public class Program {

    // Time: O(n*str_len!)    Space: O(n)
    public static List<String> longestStringChain(List<String> strings) {
        List<String> ret = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String s : strings)
            set.add(s);

        for (int i=0, len=strings.size(); i<len; i++) {
            String s = strings.get(i);
            List<String> ans = helper(set, s, Arrays.asList(s));
            if (ans.size() > ret.size())
                ret = ans;
        }

        return ret.size() > 1 ? ret : new ArrayList<>();
    }

    private static List<String> helper(Set<String> set, String s, List<String> list) {
        List<String> ret = list;

        for (int i=0, len=s.length(); i<len; i++) {
            String newS = s.substring(0, i) + s.substring(i + 1, len);
            if (set.contains(newS)) {
                List<String> l = new ArrayList<>(list);
                l.add(newS);
                List<String> res = helper(set, newS, l);
                if (res.size() > ret.size())
                    ret = res;
            }
        }

        return ret;
    }

}
