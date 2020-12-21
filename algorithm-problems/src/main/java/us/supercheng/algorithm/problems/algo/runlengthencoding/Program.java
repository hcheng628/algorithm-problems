package us.supercheng.algorithm.problems.algo.runlengthencoding;

import java.util.*;

public class Program {

    public String runLengthEncoding_Solution1(String string) {
        StringBuilder sb = new StringBuilder();
        int len = string.length(),
            count = 1;
        char c = string.charAt(0);

        for (int i=1; i<len; i++) {
            char curr = string.charAt(i);
            boolean setC = true;

            if (curr == c) {
                count++;
                if (count == 9 || i == len - 1) {
                    sb.append(count + "" + c);
                    count = 0;
                    if (i + 1 < len) {
                        setC = false;
                        c = string.charAt(i+1);
                    }
                }
            } else {
                sb.append(count + "" + c);
                count = 1;
            }
            if (setC)
                c = curr;
        }

        if (count != 0)
            sb.append(count + "" + c);

        return sb.toString();
    }

    public String runLengthEncoding_Solution2(String string) {
        StringBuilder sb = new StringBuilder();
        char c = string.charAt(0);
        int count = 1;

        for (int i=1, len = string.length(); i<len; i++) {
            if (count == 9) {
                sb.append(Integer.toString(count) + String.valueOf(c));
                count = 0;
            }

            char curr = string.charAt(i);
            if (curr == c)
                count++;
            else {
                if (count > 0)
                    sb.append(Integer.toString(count) + String.valueOf(c));
                count = 1;
            }
            c = curr;
        }

        if (count > 0)
            sb.append(Integer.toString(count) + String.valueOf(c));

        return sb.toString();
    }

    public String runLengthEncoding_Solution3(String string) {
        StringBuilder sb = new StringBuilder();
        int count = 1,
            len=string.length();

        for (int i=1; i<len; i++) {
            char prev = string.charAt(i-1);
            if (count == 9 || prev != string.charAt(i)) {
                sb.append(count);
                sb.append(prev);
                count = 1;
            } else
                count++;
        }

        sb.append(count);
        sb.append(string.charAt(len-1));

        return sb.toString();
    }
}
