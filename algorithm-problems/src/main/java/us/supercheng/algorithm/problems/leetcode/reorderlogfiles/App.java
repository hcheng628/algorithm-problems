package us.supercheng.algorithm.problems.leetcode.reorderlogfiles;

import java.util.ArrayList;
import java.util.List;

public class App {

    public String[] reorderLogFiles(String[] logs) {
        List<String> digitLogs = new ArrayList<>(),
                letterLogs = new ArrayList<>();

        for(int i=0;i<logs.length;i++) {
            if(isDigitLog(logs, i)) {
                if(letterLogs.size() == 0)
                    letterLogs.add(logs[i]);
                else {
                    boolean isAdded = false;
                    for(int j=0;j<letterLogs.size() && !isAdded;j++)
                        if(this.letterAIsBigger(logs[i], letterLogs.get(j))) {
                            letterLogs.add(j, logs[i]);
                            isAdded = true;
                        }
                    if(!isAdded)
                        letterLogs.add(logs[i]);
                }
            } else
                digitLogs.add(logs[i]);
        }

        int count = 0;
        for(String each : letterLogs)
            logs[count++] = each;
        for(String each : digitLogs)
            logs[count++] = each;
        return logs;
    }

    private boolean letterAIsBigger(String a, String b) {
        int res = a.substring(a.indexOf(' ') + 1).compareTo(b.substring(b.indexOf(' ') + 1));
        if(res < 0)
            return true;
        else if( res > 0)
            return false;
        else
            return a.substring(0, a.indexOf(' ')).compareTo(b.substring(0, b.indexOf(' '))) < 0;
    }

    private boolean isDigitLog(String[] logs, int x) {
        return Character.isLetter(logs[x].charAt(logs[x].indexOf(' ') + 1));
    }

}
