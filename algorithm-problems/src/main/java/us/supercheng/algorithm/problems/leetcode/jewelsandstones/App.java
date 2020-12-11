package us.supercheng.algorithm.problems.leetcode.jewelsandstones;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        PrintHelper.echoLn(new App().numJewelsInStones1(J, S));
    }

    public int numJewelsInStones1(String J, String S) {
        Set<Character> set = new HashSet<>();
        char[] charsJ = J.toCharArray();
        char[] charsS = S.toCharArray();
        int ret = 0;

        for(char eachJ : charsJ)
            set.add(eachJ);
        for(char eachS : charsS)
            if(set.contains(eachS))
                ret++;
        return ret;
    }

    public int numJewelsInStones(String J, String S) {
        int ret = 0;
        for (int i = 0; i < S.length(); i++)
            if (J.indexOf(S.charAt(i)) != -1)
                ret++;
        return ret;
    }
}