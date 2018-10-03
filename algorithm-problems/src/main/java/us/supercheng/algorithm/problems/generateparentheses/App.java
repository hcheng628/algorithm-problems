package us.supercheng.algorithm.problems.generateparentheses;

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
}