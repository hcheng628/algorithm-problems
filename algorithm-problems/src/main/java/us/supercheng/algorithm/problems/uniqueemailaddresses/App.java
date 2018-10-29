package us.supercheng.algorithm.problems.uniqueemailaddresses;

import java.util.HashSet;
import java.util.Set;

public class App {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(String email : emails) {
            int atIndex = email.indexOf('@');
            for(int i=0;i<atIndex;i++) {
                char each = email.charAt(i);
                if(each != '.') {
                    if(each == '+')
                        break;
                    sb.append(each);
                }
            }
            set.add(sb.toString() + email.substring(atIndex));
            sb.setLength(0);
        }
        return set.size();
    }
}