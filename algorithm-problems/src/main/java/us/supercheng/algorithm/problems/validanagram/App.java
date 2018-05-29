package us.supercheng.algorithm.problems.validanagram;

import java.util.Arrays;

public class App {

    public static void main (String[] args) {
        App app = new App();
        String s = "jamesmaddson";
        String t = "maddsonjames";
        System.out.println(app.isAnagram2(s, t));
        System.out.println(app.isAnagram2(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        if(s.length() != t.length())
            return false;

        int size = s.length();
        char eachChar = '@';
        int index = -1;
        for(int count=0; count < size; count ++) {
            index = t.indexOf(s.charAt(count));
            if(index == -1) {
                return false;
            }
            t = t.substring(0, index) + t.substring(index+1, t.length());
        }
        return t.length() == 0;
    }


    public boolean isAnagram2(String s, String t) {
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        if(s.length() != t.length())
            return false;
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        Arrays.sort(arrS);
        Arrays.sort(arrT);
        for(int i=0;i<arrS.length;i++) {
            if(arrS[i] != arrT[i]) {
                return false;
            }
        }
        return true;
    }
}