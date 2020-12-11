package us.supercheng.algorithm.problems.leetcode.goatlatin;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        String S = "Each word consists of lowercase and uppercase letters only";
        PrintHelper.echoLn(new App().toGoatLatin(S));
    }

    public String toGoatLatin(String S) {
        String words [] = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<words.length;i++) {
            char firstC = words[i].charAt(0);
            if(firstC == 'a' || firstC == 'e' || firstC == 'i' || firstC == 'o' || firstC == 'u' ||
                    firstC == 'A' || firstC == 'E' || firstC == 'I' || firstC == 'O' || firstC == 'U')
                sb.append(words[i] + "ma");
            else
                sb.append(words[i].substring(1, words[i].length()) + firstC + "ma");
            for(int j=0;j<i+1;j++)
                sb.append("a");
            if(i != words.length -1)
                sb.append(" ");
        }
        return sb.toString();
    }
}