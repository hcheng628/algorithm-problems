package us.supercheng.algorithm.problems.dota2senate;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public String predictPartyVictory(String senate) {
        Queue<Integer> qD = new LinkedList<>(),
                       qR = new LinkedList<>();
        int len = senate.length();

        for (int i=0;i<len;i++)
            if (senate.charAt(i) == 'R')
                qR.add(i);
            else
                qD.add(i);

        while (!qR.isEmpty() && !qD.isEmpty()) {
            int idxD = qD.remove(),
                idxR = qR.remove();
            if (idxD < idxR)
                qD.add(idxD + len);
            else
                qR.add(idxR + len);
        }

        return qR.isEmpty() ? "Dire" : "Radiant";
    }
}