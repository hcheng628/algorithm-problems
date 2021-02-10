package us.supercheng.algorithm.problems.algo.tournamentwinner;

import java.util.*;

public class Program {

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> stats = new HashMap<>();
        String ret = "";

        for (int i=0, max = 0, len=competitions.size(); i<len; i++) {
            List<String> match = competitions.get(i);
            String home = match.get(0);
            String away = match.get(1);
            if (results.get(i) == 0) {
                stats.put(away, stats.getOrDefault(away, 0) + 3);
                Integer score = stats.get(away);
                if (score > max) {
                    max = score;
                    ret = away;
                }
            } else {
                stats.put(home, stats.getOrDefault(home, 0) + 3);
                Integer score = stats.get(home);
                if (score > max) {
                    max = score;
                    ret = home;
                }
            }
        }

        return ret;
    }
}
