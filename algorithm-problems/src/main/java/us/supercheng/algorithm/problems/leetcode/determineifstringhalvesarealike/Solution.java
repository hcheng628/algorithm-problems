package us.supercheng.algorithm.problems.leetcode.determineifstringhalvesarealike;

public class Solution {

    static boolean[] set = new boolean[128];

    static {
        for(char c : new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'})
            set [c - 'A'] = true;
    }

    public boolean halvesAreAlike(String s) {
        int a = 0;
        int b = 0;

        for (int i=0, half=s.length()/2; i<half; i++) {
            if (set[s.charAt(i) - 'A'])
                a++;
            if (set[s.charAt(i + half) - 'A'])
                b++;
        }

        return a == b;
    }

}