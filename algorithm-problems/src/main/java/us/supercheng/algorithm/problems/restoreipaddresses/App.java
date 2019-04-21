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


    List<List<Integer>> ipList;

    public List<String> restoreIpAddresses2(String s) {
        this.ipList = new ArrayList<>();
        List<String> ret = new ArrayList<>();
        this.ipListHelper(s, new ArrayList<>());

        for (List<Integer> list : this.ipList) {
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<4;i++) {
                sb.append(list.get(i));
                if (i != 3)
                    sb.append('.');
            }
            ret.add(sb.toString());
        }
        return ret;
    }


    private void ipListHelper(String s, List<Integer> list) {
        if (s.length() == 0 && list.size() == 4)
            this.ipList.add(new ArrayList(list));

        if (s.length() == 0 || list.size() == 4)
            return;

        this.listHelper(s.charAt(0) - '0', s.substring(1), list);

        if (1 < s.length() && s.charAt(0) != '0')
            this.listHelper((s.charAt(0) - '0') * 10 + (s.charAt(1) - '0'), s.substring(2), list);

        if (2 < s.length() && s.charAt(0) != '0') {
            int num = (s.charAt(0) - '0') * 100 + (s.charAt(1) - '0') * 10 + (s.charAt(2) - '0');
            if (num < 256)
                this.listHelper(num, s.substring(3), list);
        }
    }

    private void listHelper(int num, String s, List<Integer> list) {
        list.add(num);
        this.ipListHelper(s, list);
        list.remove(list.size()-1);
    }
}
