package us.supercheng.algorithm.problems.algo.longeststringchain;

import java.util.*;


public class Program {

    public static List<String> longestStringChain(List<String> strings) {
        String maxStr = "";
        int maxChain = 0;
        Map<String, Node> map = new HashMap<>();

        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });


        for (String s : strings) {
            int count = helper(map, s);
            if (count > maxChain) {
                maxChain = count;
                maxStr = s;
            }
        }


        return maxChain > 1 ? buildRet(map, maxStr) : new ArrayList<>();
    }

    private static List<String> buildRet(Map<String, Node> map, String s) {
        List<String> ret = new ArrayList<>();
        ret.add(s);

        String curr = s;
        while (map.containsKey(curr)) {
            Node n = map.get(curr);
            if (n.next.length() == 0)
                break;
            ret.add(n.next);
            curr = n.next;
        }

        return ret;
    }

    private static int helper(Map<String, Node> map, String s) {
        Node n = new Node();
        map.put(s, n);

        for (int i=0, len = s.length(); i<len; i++) {
            String newS = s.substring(0, i) + s.substring(i + 1, len);
            Node next = map.get(newS);
            if (next != null && next.count + 1 > n.count) {
                n.next = newS;
                n.count = next.count + 1;
            }
        }

        return n.count;
    }


    static class Node {
        String next;
        int count;

        public Node() {
            this.next = "";
            this.count = 1;
        }
    }

}
