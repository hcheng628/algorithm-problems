package us.supercheng.algorithm.problems.leetcode.goalparserinterpretation;

public class Solution {

    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();

        for (int i=0, len=command.length(); i<len; i++) {
            char c = command.charAt(i);

            if (c == 'G')
                sb.append(c);
            else {
                if (command.charAt(i+1) == ')') {
                    sb.append('o');
                    i++;
                } else {
                    sb.append("al");
                    i +=3;
                }
            }
        }

        return sb.toString();
    }
}