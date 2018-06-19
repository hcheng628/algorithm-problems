package us.supercheng.algorithm.problems.uniquemorsecodewords;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        App app = new App();
        String[] arr = {"gin", "zen", "gig", "msg"};
        PrintHelper.echoLn(app.uniqueMorseRepresentations(arr));
    }

    public int uniqueMorseRepresentations(String[] words) {
        String [] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();

        for(int i=0;i<words.length;i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<words[i].length();j++) {
                sb.append(codes[words[i].charAt(j) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}