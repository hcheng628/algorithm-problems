package us.supercheng.algorithm.problems.positionsoflargegroups;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        String S = "abcdddeeeeaabbbcd";
        List<List<Integer>> res = new App().largeGroupPositions(S);
        for(List<Integer> each : res) {
            for(int eachVal : each)
                PrintHelper.echo(eachVal + " ");
            PrintHelper.echoLn("");
        }

        res = new App().largeGroupPositions1(S);
        for(List<Integer> each : res) {
            for(int eachVal : each)
                PrintHelper.echo(eachVal + " ");
            PrintHelper.echoLn("");
        }

    }

    public List<List<Integer>> largeGroupPositions1(String S) {
        List<List<Integer>> ret = new ArrayList<>();
        char [] chars = S.toCharArray();
        int count = 1;
        for(int i=0;i<chars.length;i++) {
            if(i+1 <= chars.length-1 && chars[i] == chars[i+1]) {
                count++;
            } else if (i+1 <= chars.length-1 && chars[i] != chars[i+1]) {
                if(count >=3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i-count+1);
                    list.add(i);
                    ret.add(list);
                }
                count=1;
            } else if (i == chars.length-1 && i-1 >=0) {
                if(chars[i] == chars[i-1]) {
                    if(count >=3) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i-count+1);
                        list.add(i);
                        ret.add(list);
                    }
                }
            }
        }
        return ret;
    }

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int prev=0, count=0, i=0;
        for(;i<S.length();i++) {
            if(S.charAt(i) == S.charAt(prev))
                count++;
            else {
                if(count>2) {
                    List<Integer> list = new ArrayList<>();
                    list.add(prev);
                    list.add(i-1);
                    ret.add(list);
                }
                prev=i;
                count=1;
            }
        }
        if(count>2) {
            List<Integer> list = new ArrayList<>();
            list.add(prev);
            list.add(i-1);
            ret.add(list);
        }
        return ret;
    }
}