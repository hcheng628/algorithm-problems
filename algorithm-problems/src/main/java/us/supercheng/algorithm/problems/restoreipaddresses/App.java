package us.supercheng.algorithm.problems.restoreipaddresses;

import java.util.ArrayList;
import java.util.List;

public class App {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        if(s.length() > 12)
            return ret;
        this.helper(ret, s, "", 0, 0, s.length()+3);
        return ret;
    }

    private void helper(List<String> list, String s, String subS, int index, int dotCount, int endLength) {
        if(dotCount > 4 || index > s.length())
            return;

        if(endLength == subS.length() && index == s.length())
            list.add(subS);

        for(int i=index;i<s.length();i++) {
            char curr = s.charAt(i);
            this.helper(list, s, i+1 != s.length() ? subS + curr + "." : subS + curr, i+1, dotCount + 1, endLength);

            if(i+1 <= s.length() -1 && curr != '0')
                this.helper(list, s, i+2 != s.length() ? subS + s.substring(i,i+2)+ "." : subS + s.substring(i,i+2), i+2, dotCount + 1, endLength);

            if(i+2 <= s.length() - 1 && s.charAt(i) != '0') {
                int subIp = Integer.parseInt(s.substring(i,i+3));
                if(subIp <= 255)
                    this.helper(list, s, i+3 != s.length() ? subS + subIp + "." : subS + subIp, i+3, dotCount + 1, endLength);
            }
        }
    }
}
