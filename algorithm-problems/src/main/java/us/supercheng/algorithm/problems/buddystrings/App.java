package us.supercheng.algorithm.problems.buddystrings;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        String A = "aaaaaaabc", B = "aaaaaacba";
        PrintHelper.echoLn(new App().buddyStrings(A, B));
    }

    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length() || A.length() == 1 || B.length() == 1)
            return false;

        char[] charA = A.toCharArray();
        int count = 0, swapA = -1, swapB = -1;
        for(int i=0;i<charA.length;i++) {
            if(charA[i] != B.charAt(i)) {
                count++;
                if(swapA == -1)
                    swapA = i;
                else
                    swapB = i;
            }
            if(count > 2)
                return false;
        }

        if(count == 1)
            return false;

        if(count == 0) {
            Arrays.sort(charA);
            for(int i=0;i<charA.length-1;i++)
                if(charA[i] == charA[i+1])
                    return true;
            return false;
        } else
            return charA[swapA] == B.charAt(swapB) && charA[swapB] == B.charAt(swapA);
    }
}