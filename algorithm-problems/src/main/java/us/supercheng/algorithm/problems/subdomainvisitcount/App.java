package us.supercheng.algorithm.problems.subdomainvisitcount;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        String [] cpDomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        for(String each : new App().subdomainVisits(cpDomains))
            PrintHelper.echoLn(each);
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> ret = new ArrayList<>();
        for(String each : cpdomains) {
            int count = Integer.parseInt(each.substring(0, each.indexOf(" ")));
            String domains = each.substring(each.indexOf(" ")+1, each.length());
            while(domains.indexOf(".")>=0) {
                map.put(domains, map.getOrDefault(domains, 0) + count);
                domains = domains.substring(domains.indexOf(".")+1, domains.length());
            }
            map.put(domains, map.getOrDefault(domains, 0) + count);
        }
        for(String key : map.keySet())
            ret.add(map.get(key) + " " + key);
        return ret;
    }
}