package us.supercheng.algorithm.problems.lettercasepermutation;

import us.supercheng.algorithm.common.helper.PrintHelper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        String S = "docker";
        for(String each : new App().letterCasePermutation(S))
            PrintHelper.echoLn(each);
    }

    public List<String> letterCasePermutation(String S) {
        if(S == null || S.length() < 1) {
            List<String> ret = new ArrayList<>();
            ret.add("");
            return ret;
        }

        Set<String> set = new HashSet<>();
        S = S.toLowerCase();
        helper(S, 0, set);
        List<String> ret = new ArrayList<>();
        for(String each : set)
            ret.add(each);
        return ret;
    }

    private void helper(String S, int index, Set<String> set) {
        if(index > S.length()-1)
            return;
        if(!set.contains(S))
            set.add(S);
        helper(S,index+1, set);
        String sUpper = S.substring(0,index) + (S.charAt(index)+"").toUpperCase() + S.substring(index+1, S.length());
        if(!set.contains(sUpper))
            set.add(sUpper);
        helper(sUpper,index+1, set);
    }
}