package us.supercheng.algorithm.problems.leetcode.findsmallestlettergreaterthantarget;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Arrays;

public class App {

    public static void main(String [] args) {
        char [] letters = {'e','e','e','e','e','e','n','n','n','n'};
        char target = 'n';
        PrintHelper.echoLn(new App().nextGreatestLetter(letters, target));
    }

    public char nextGreatestLetter1(char[] letters, char target) {
        for(int i=0;i<letters.length;i++)
            if((i != letters.length -1 && letters[i] != letters[i+1] && letters[i] > target) || (i == letters.length -1 && letters[i] > target))
                return letters[i];
        return letters[0];
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int index = Arrays.binarySearch(letters, target);
        if(index < 0) {
            index = -1 * (index+1);
            if(index <= letters.length -1)
                return letters[index];
        } else {
            for(int i=index;i<letters.length;i++)
                if((i != letters.length - 1 && letters[i] != letters[i+1] && letters[i] > target )   || (i == letters.length - 1 && letters[i] > target))
                    return letters[i];
        }
        return letters[0];
    }
}