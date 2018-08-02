package us.supercheng.algorithm.problems.findsmallestlettergreaterthantarget;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String [] args) {
        char [] letters = {'e','e','e','e','e','e','n','n','n','n'};
        char target = 'n';
        PrintHelper.echoLn(new App().nextGreatestLetter(letters, target));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        for(int i=0;i<letters.length;i++) {
            if(i != letters.length -1 && letters[i] != letters[i+1] && letters[i] > target)
                return letters[i];
            else if (i == letters.length -1 && letters[i] > target)
                return letters[i];
        }
        return letters[0];
    }

}