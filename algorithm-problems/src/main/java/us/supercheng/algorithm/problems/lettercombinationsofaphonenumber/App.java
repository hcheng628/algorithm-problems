package us.supercheng.algorithm.problems.lettercombinationsofaphonenumber;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;
import java.util.List;

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
}
