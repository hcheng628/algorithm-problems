package us.supercheng.algorithm.problems.reformatthestring;

public class Solution {

    public String reformat(String s) {
        int countC = 0,
            countD = 0,
            len = s.length();

        if (len == 1)
            return s;

        int[] arrD = new int[10],
                arrC = new int[26];

        for (char c : s.toCharArray())
            if (Character.isDigit(c)) {
                arrD[c - '0']++;
                countD++;
            } else {
                arrC[c - 'a']++;
                countC++;
            }

        if (Math.abs(countC - countD) > 1)
            return "";

        StringBuilder sb = new StringBuilder();
        int idxC = 0,
            idxD = 0;

        if (countC > countD)
            while (sb.length() != len) {
                if (arrC[idxC] > 0) {
                    arrC[idxC]--;
                    sb.append((char) (idxC + 'a'));
                } else {
                    while(idxC < 26 && arrC[idxC] < 1)
                        idxC++;
                    if (idxC < 26) {
                        arrC[idxC]--;
                        sb.append((char) (idxC + 'a'));
                    }
                }

                if (arrD[idxD] > 0) {
                    arrD[idxD]--;
                    sb.append((char) (idxD + '0'));
                } else {
                    while (idxD < 10 && arrD[idxD] < 1)
                        idxD++;

                    if (idxD < 10) {
                        arrD[idxD]--;
                        sb.append((char) (idxD + '0'));
                    }
                }
            }
        else
            while (sb.length() != len) {
                if (arrD[idxD] > 0) {
                    arrD[idxD]--;
                    sb.append((char) (idxD + '0'));
                } else {
                    while (idxD < 10 && arrD[idxD] < 1)
                        idxD++;

                    if (idxD < 10) {
                        arrD[idxD]--;
                        sb.append((char) (idxD + '0'));
                    }
                }

                if (arrC[idxC] > 0) {
                    arrC[idxC]--;
                    sb.append((char) (idxC + 'a'));
                } else {
                    while(idxC < 26 && arrC[idxC] < 1)
                        idxC++;

                    if (idxC < 26) {
                        arrC[idxC]--;
                        sb.append((char) (idxC + 'a'));
                    }
                }
            }

        return sb.toString();
    }
}
