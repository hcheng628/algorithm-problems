package us.supercheng.algorithm.problems.leetcode.lettercasepermutation;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.*;

public class App {

    public static void main(String[] args) {
        String S = "docker";

        for(String each : new App().letterCasePermutation(S))
            PrintHelper.echo(each + " ");

        PrintHelper.echoLn("");

        for(String each : new App().letterCasePermutation1(S))
            PrintHelper.echo(each + " ");

        PrintHelper.echoLn("");

        for(String each : new App().letterCasePermutation2(S))
            PrintHelper.echo(each + " ");
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

    public List<String> letterCasePermutation1(String S) {
        List<String> ret  = new ArrayList<>();
        this.helper1(ret, S, 0);
        return ret;
    }

    private void helper1(List<String> list, String s, int curr) {
        if(curr == s.length()) {
            list.add(s);
            return;
        }

        char [] chars = s.toCharArray();
        if(Character.isLetter(chars[curr])) {
            chars[curr] = Character.toLowerCase(chars[curr]);
            this.helper1(list, String.valueOf(chars), curr+1);
            chars[curr] = Character.toUpperCase(chars[curr]);
            this.helper1(list, String.valueOf(chars), curr+1);
        } else
            this.helper1(list, s, curr+1);
    }

    public List<String> letterCasePermutation2(String S) {
        Queue<String> queue = new LinkedList<>();
        queue.add(S);
        for (int i=0;i<S.length();i++) {
            if(Character.isLetter(S.charAt(i))) {
                int size = queue.size();
                for(int j=0;j<size;j++) {
                    char[] eachChars = queue.poll().toCharArray();
                    queue.add(String.valueOf(eachChars));
                    if(eachChars[i] < 97)
                        eachChars[i] = Character.toLowerCase(eachChars[i]);
                    else
                        eachChars[i] = Character.toUpperCase(eachChars[i]);
                    queue.add(String.valueOf(eachChars));
                }
            }
        }
        return (List)queue;
    }
}