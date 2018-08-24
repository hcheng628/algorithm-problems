package us.supercheng.algorithm.problems.mostcommonword;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"bob"};
        PrintHelper.echoLn(new App().mostCommonWord(paragraph, banned));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";
        char[] chars = paragraph.toLowerCase().toCharArray();
        Map<String, Integer> map = new HashMap<>();
        Set<String> bans = new HashSet<>();
        for(String each : banned)
            bans.add(each);

        StringBuilder eachWordSb = new StringBuilder();
        String ret = "";
        int max = 0;
        for(char each : chars) {
            if(!Character.isLetter(each)&& eachWordSb.length()>0) {
                String temp = eachWordSb.toString();
                if(!bans.contains(temp)) {
                    map.put(temp, map.getOrDefault(temp,0)+1);
                    if(map.get(temp) > max) {
                        max = map.get(temp);
                        ret = eachWordSb.toString();
                    }
                }
                eachWordSb.setLength(0);
            } else if (Character.isLetter(each))
                eachWordSb.append(each);
        }
        return ret;
    }
}
