package us.supercheng.algorithm.problems.ransomnote;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        App app = new App();
        PrintHelper.echoLn(app.canConstruct("SteveNash", "James"));
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
}
