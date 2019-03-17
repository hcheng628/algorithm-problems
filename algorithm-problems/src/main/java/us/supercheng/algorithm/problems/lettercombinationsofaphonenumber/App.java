package us.supercheng.algorithm.problems.lettercombinationsofaphonenumber;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        String digits = "32837";
        for(String each : new App().letterCombinations(digits)) {
            PrintHelper.echoLn(each);
        }
    }

    List<String> ret = new ArrayList<>();
    String[] bucket = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() < 1)
            return ret;
        this.helper(digits, 0, "");
        return ret;
    }

    private void helper(String digits, int index, String newS) {
        if(index >= digits.length()) {
            this.ret.add(newS);
            return;
        }

        for(char each : this.bucket[digits.charAt(index) - '0'].toCharArray())
            this.helper(digits, index+1, newS + each);
    }




    private List<String> list =  new ArrayList<>();
    private Map<Integer, String> map = new HashMap<>();

    public List<String> letterCombinations2(String digits) {
        if (digits == null || digits.length() == 0)
            return list;

        this.map.put(2, "abc");
        this.map.put(3, "def");
        this.map.put(4, "ghi");
        this.map.put(5, "jkl");
        this.map.put(6, "mno");
        this.map.put(7, "pqrs");
        this.map.put(8, "tuv");
        this.map.put(9, "wxyz");

        this.dfs(digits, 0, "");

        return list;
    }

    private void dfs(String digits, int idx, String s) {
        if (idx == digits.length()) {
            this.list.add(s);
            return;
        }

        for (char each : this.map.get(digits.charAt(idx) - '0').toCharArray())
            this.dfs(digits, idx+1, s + each);
    }
}
