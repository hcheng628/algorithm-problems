package us.supercheng.algorithm.problems.stringwithoutaaaorbbb;

class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();

        while (A > 0 || B > 0) {
            boolean writeA = false;
            int currLen = sb.length();
            if((currLen > 1 && sb.charAt(currLen - 1) == sb.charAt(currLen - 2)))
                if (sb.charAt(currLen - 2) == 'b')
                    writeA = true;
            else if (A >= B)
                writeA = true;

            if (writeA) {
                sb.append('a');
                A--;
            } else {
                sb.append('b');
                B--;
            }
        }

        return sb.toString();
    }
}