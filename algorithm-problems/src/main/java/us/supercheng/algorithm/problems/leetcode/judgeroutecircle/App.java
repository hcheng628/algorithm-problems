package us.supercheng.algorithm.problems.leetcode.judgeroutecircle;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.HashMap;

public class App {

    public static void main(String[] args) {
        String s = "UUDDLLRR";
        PrintHelper.echoLn(new App().judgeCircle(s));
        PrintHelper.echoLn(new App().judgeCircle2(s));
        PrintHelper.echoLn(new App().judgeCircle3(s));

    }

    public boolean judgeCircle(String moves) {
        if(moves == null || moves.length() ==0)
            return true;
        char [] chars = moves.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('U', 0);
        map.put('D', 0);
        map.put('L', 0);
        map.put('R', 0);
        for(int i=0;i<chars.length;i++)
            map.put(chars[i], map.get(chars[i]) + 1);
        return (map.get('U').equals(map.get('D'))) && (map.get('L').equals(map.get('R'))) ? true : false;
    }

    public boolean judgeCircle2(String moves) {
        if(moves == null || moves.length() ==0)
            return true;

        char [] chars = moves.toCharArray();
        int countU=0, countD=0, countL=0, countR=0;

        for(char each : chars) {
            if(each == 'U')
                countU++;
            else if (each == 'D')
                countD++;
            else if (each == 'L')
                countL++;
            else if (each == 'R')
                countR++;
        }
        return (countU == countD) && (countL == countR) ? true : false;
    }

    public boolean judgeCircle3(String moves) {
        if(moves == null || moves.length() ==0)
            return true;

        int h=0, v=0;
        for(char each : moves.toCharArray()) {
            switch (each) {
                case 'U':
                    v++;
                    break;
                case 'D':
                    v--;
                    break;
                case 'L':
                    h++;
                    break;
                case 'R':
                    h--;
                    break;
            }
        }
        return v ==0 && h == 0;
    }
}
