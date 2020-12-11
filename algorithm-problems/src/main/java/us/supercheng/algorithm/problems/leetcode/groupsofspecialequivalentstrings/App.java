package us.supercheng.algorithm.problems.leetcode.groupsofspecialequivalentstrings;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        String [] A = {"abc","acb","bac","bca","cab","cba"};
        PrintHelper.echoLn("Count: " + new App().numSpecialEquivGroups(A));
    }

    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for(String each : A)
            set.add(each.length()==1 ? each : this.helper(each));
        return set.size();
    }

    private String helper(String str) {
        int [] chars = new int[52];
        int odd = 0;
        for(char eachChar : str.toCharArray())
            chars[(odd++ % 2 == 0 ? 26 : 0) + eachChar - 'a']++;
        StringBuilder sb = new StringBuilder();
        for(int each : chars)
            sb.append(each);
        return sb.toString();
    }
}