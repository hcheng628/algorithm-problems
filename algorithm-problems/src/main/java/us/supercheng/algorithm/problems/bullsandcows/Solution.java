package us.supercheng.algorithm.problems.bullsandcows;

class Solution {
    public String getHint(String secret, String guess) {
        int [] setS = new int [10],
                setG = new int [10];

        int aCount=0, bCount=0;
        for (int i=0; i<secret.length();i++) {
            char eachS = secret.charAt(i),
                    eachG = guess.charAt(i);
            if (eachS == eachG) {
                aCount++;
                continue;
            }
            setS[eachS-'0']++;
            setG[eachG-'0']++;
        }

        for (int i=0;i<10;i++)
            bCount += Math.min(setS[i], setG[i]);

        return aCount+"A"+bCount+"B";
    }
}