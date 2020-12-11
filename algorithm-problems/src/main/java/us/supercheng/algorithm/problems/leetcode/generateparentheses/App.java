package us.supercheng.algorithm.problems.leetcode.generateparentheses;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        int n = 13, count = 0;
        for(String each :  new App().generateParenthesis(n)) {
            PrintHelper.echoLn(each);
            count++;
        }
        PrintHelper.echoLn("Total: " + count);

        count = 0;
        for(String each :  new App().generateParenthesis2(n)) {
            PrintHelper.echoLn(each);
            count++;
        }
        PrintHelper.echoLn("Total: " + count);
    }

    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();

        if(n<1)
            return ret;

        this.helper("", ret, n, n);
        return ret;
    }

    private void helper(String s, List<String> ret, int left, int right) {
        if(left == 0 && right ==0) {
            ret.add(s);
            return;
        }

        if(left > right)
            return;

        if(left > 0)
            this.helper(s + "(", ret, left-1, right);
        if(right > 0)
            this.helper(s + ")", ret, left, right-1);
    }

    public List<String> generateParenthesis2(int n) {
        List<String> ret = new ArrayList<>();

        if(n<1)
            return ret;

        this.helper2(new StringBuilder(), ret, n, n);
        return ret;
    }

    private void helper2(StringBuilder sb, List<String> ret, int left, int right) {
        if(left == 0 && right ==0) {
            ret.add(sb.toString());
            return;
        }

        if(left > right)
            return;

        if(left > 0) {
            this.helper2(sb.append("("), ret, left-1, right);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(right > 0) {
            this.helper2(sb.append(")"), ret, left, right-1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}