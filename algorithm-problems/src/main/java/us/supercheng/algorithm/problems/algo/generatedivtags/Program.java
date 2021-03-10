package us.supercheng.algorithm.problems.algo.generatedivtags;

import java.util.*;

public class Program {

    String open = "<div>";
    String close = "</div>";

    public ArrayList<String> generateDivTags(int numberOfTags) {
        // return method1(numberOfTags);
        return method2(numberOfTags);
    }

    private ArrayList<String> method1(int numberOfTags) {
        Set<String> set = new HashSet<>();
        this.helper(numberOfTags, 0, 0, "", set);
        return new ArrayList<>(set);
    }

    private void helper(int total, int openCount, int closeCount, String s, Set<String> list) {
        if (total == openCount && total == closeCount) {
            list.add(s);
            return;
        }

        if (openCount < total) {
            this.helper(total, openCount + 1, closeCount, s + open, list);
            for (int i=0, len=total - openCount; i<len; i++)
                if (closeCount < openCount)
                    this.helper(total, openCount, closeCount + 1, s + close, list);
        } else
            this.helper(total, openCount, closeCount + 1, s + close, list);
    }

    private ArrayList<String> method2(int numberOfTags) {
        ArrayList<String> ret = new ArrayList<>();
        helper2(numberOfTags, numberOfTags, "", ret);
        return ret;
    }


    private void helper2(int openCount, int closeCount, String s, ArrayList<String> list) {
        if (openCount == 0 && closeCount == 0) {
            list.add(s);
            return;
        }

        if (openCount > 0)
            this.helper2(openCount - 1, closeCount, s + open, list);

        if (closeCount > openCount)
            this.helper2(openCount, closeCount - 1, s + close, list);
    }

    public static void main(String[] args) {
        Program app = new Program();
        ArrayList<String> res = app.generateDivTags(3);
        System.out.println(res);
    }

}
