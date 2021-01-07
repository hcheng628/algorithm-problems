package us.supercheng.algorithm.problems.algo.validipaddresses;

import java.util.*;

public class Program {

    public ArrayList<String> validIPAddresses_Solution1(String string) {
        return this.helper(string, new ArrayList<>(), new ArrayList<>());
    }

    private ArrayList<String> helper(String s, ArrayList<String> ret, ArrayList<String> list) {
        if (s.length() == 0 || list.size() > 4) {
            if (list.size() == 4)
                ret.add(String.join(".", list));
            return ret;
        }

        for (int i=1; i<=3 && i <= s.length(); i++) {
            String curr = s.substring(0, i);
            String newS = s.substring(i);

            if (this.isValidIP(curr)) {
                list.add(curr);
                this.helper(newS, ret, list);
                list.remove(list.size() - 1);
            }
        }

        return ret;
    }

    public ArrayList<String> validIPAddresses_Solution2(String string) {
        ArrayList<String> ret = new ArrayList<>();
        String[] ip = new String[4];

        for (int i=1, len=string.length(); i<len; i++) {
            String s = string.substring(0, i);
            if (this.isValidIP(s))
                ip[0] = s;
            else
                continue;

            for (int j=i+1; j<len; j++) {
                s = string.substring(i, j);
                if (this.isValidIP(s))
                    ip[1] = s;
                else
                    continue;

                for (int k=j+1; k<len; k++) {
                    s = string.substring(j, k);
                    if (this.isValidIP(s))
                        ip[2] = s;
                    else
                        continue;

                    s = string.substring(k);
                    if (!this.isValidIP(s))
                        continue;
                    ip[3] = s;

                    ret.add(String.join(".", ip));
                }
            }
        }

        return ret;
    }

    private boolean isValidIP(String s) {
        try {
            int num = Integer.parseInt(s);
            return num >= 0 && num <= 255 && String.valueOf(num).length() == s.length();
        } catch(Exception ex) {
            return false;
        }
    }
}


