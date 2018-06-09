package us.supercheng.algorithm.problems.ransomnote;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        App app = new App();
        PrintHelper.echoLn(app.canConstruct("stevenash", "james"));
        PrintHelper.echoLn(app.canConstruct2("stevenash", "james"));
        PrintHelper.echoLn(app.canConstruct3("stevenash", "james"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> mapNote = new HashMap<>();
        Map<Character, Integer> mapMaga = new HashMap<>();
        char c;
        for(int i=0; i<ransomNote.length();i++) {
            c = ransomNote.charAt(i);
            if(mapNote.get(c) != null)
                mapNote.put(c, mapNote.get(c) + 1);
            else
                mapNote.put(c, 1);
        }

        for(int i=0;i<magazine.length();i++) {
            c = magazine.charAt(i);
            if(mapMaga.get(c) != null)
                mapMaga.put(c, mapMaga.get(c) + 1);
            else
                mapMaga.put(c, 1);
        }
        if(mapNote.size() > mapMaga.size()) {
            return false;
        }
        for (Character key : mapNote.keySet()) {
            if(mapMaga.get(key) == null || (mapNote.get(key) > mapMaga.get(key))) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        char [] ransoms = ransomNote.toCharArray();
        char [] magas = magazine.toCharArray();
        if(ransoms.length > magas.length)
            return false;
        Arrays.sort(ransoms);
        Arrays.sort(magas);
        int countA = 0;
        int countB = 0;
        while(countA < ransoms.length && countB < magas.length) {
            if(ransoms[countA] != magas[countB]) {
                countB++;
                if(countB > magas.length -1) {
                    return false;
                }
            } else {
                countA++;
                countB++;
            }
        }
        return countA == ransoms.length ? true :  false;
    }

    public boolean canConstruct3(String ransomNote, String magazine) {
        int [] arr = new int [26];
        for(int i=0;i<magazine.length();i++)
            arr[magazine.charAt(i) - 'a']++;
        for(int i=0;i<ransomNote.length();i++)
            if(--arr[ransomNote.charAt(i) - 'a'] < 0)
                return false;
        return true;
    }

    public boolean canConstruct4(String ransomNote, String magazine) {
        int [] arr = new int [26];
        for(char c : magazine.toCharArray())
            arr[c - 'a']++;

        for(char c : ransomNote.toCharArray())
            if(--arr[c - 'a'] < 0)
                return false;
        return true;
    }
}
