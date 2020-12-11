package us.supercheng.algorithm.problems.leetcode.accountsmerge;

import java.util.*;

public class Solution {

    // bfs/dfs
    Map<String, Set<String>> graph;
    Set<String> visited;

    List<List<String>> ret;

    class UnionFind {

        public Map<String, String> parent;

        public UnionFind(Map<String, Integer> map) {
            this.parent = new HashMap<>();
            for (String email : map.keySet())
                this.parent.put(email, email);
        }

        public void union(String emailA, String emailB) {
            this.parent.put(this.find(emailB), this.find(emailA));
        }

        public String find(String email) {
            return parent.get(email).equals(email) ? email : this.find(this.parent.get(email));
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        this.ret = new ArrayList<>();
        // dfs/bfs depends on graph + visisted
        this.accountsMergeBFS(accounts);
        this.accountsMergeDFS(accounts);
        // union find
        this.accountsMergeUF(accounts);
        return this.ret;
    }

    private void accountsMergeUF(List<List<String>> accounts) {
        Map<String, Integer> map = new HashMap<>();

        for (int i=0,len=accounts.size();i<len;i++) {
            List<String> acct = accounts.get(i);
            for (int j=1,aLen=acct.size();j<aLen;j++)
                map.put(acct.get(j), i);
        }
        UnionFind uf = new UnionFind(map);

        for (List<String> acct : accounts) {
            String root = acct.get(1);
            for (int i=2,len=acct.size();i<len;i++)
                uf.union(acct.get(i), uf.find(root));
        }

        Map<String, List<String>> eToAccount = new HashMap<>();
        for (String e : map.keySet()) {
            String root = uf.find(e);
            if (!eToAccount.containsKey(root)) {
                List<String> account = new ArrayList<>();
                account.add(accounts.get(map.get(e)).get(0));
                eToAccount.put(root, account);
            }
            eToAccount.get(root).add(e);
        }

        for (List<String> l : eToAccount.values())
            Collections.sort(l);
        this.ret = new ArrayList<>(eToAccount.values());
    }

    private void initGraph(List<List<String>> accounts) {
        for (List<String> account : accounts) {
            String key = account.get(1);
            if (!this.graph.containsKey(key))
                this.graph.put(key, new HashSet<>());

            for (int i=2,aLen=account.size();i<aLen;i++) {
                String email = account.get(i);
                if (!this.graph.containsKey(email))
                    this.graph.put(email, new HashSet<>());
                this.graph.get(key).add(email);
                this.graph.get(email).add(key);
            }
        }
    }

    private void accountsMergeBFS(List<List<String>> accounts) {
        this.graph = new HashMap<>();
        this.visited = new HashSet<>();
        this.initGraph(accounts);

        for (List<String> acct : accounts) {
            List<String> list = new ArrayList<>();
            Queue<String> queue= new LinkedList<>();
            for (int i=1,len=acct.size();i<len;i++) {
                String email = acct.get(i);
                if (this.visited.add(email))
                    queue.add(email);
                while(!queue.isEmpty()) {
                    String curr = queue.remove();
                    list.add(curr);
                    for (String next : graph.get(curr))
                        if (this.visited.add(next))
                            queue.add(next);
                }
            }
            if (!list.isEmpty()) {
                Collections.sort(list);
                list.add(0, acct.get(0));
                this.ret.add(list);
            }
        }
    }

    private void accountsMergeDFS(List<List<String>> accounts) {
        this.graph = new HashMap<>();
        this.visited = new HashSet<>();
        this.initGraph(accounts);

        for (List<String> acct : accounts) {
            List<String> list = new ArrayList<>();
            for (int i=1,len=acct.size();i<len;i++) {
                String email = acct.get(i);
                if (!this.visited.contains(email))
                    this.dfs(list, email);
            }
            if (!list.isEmpty()) {
                Collections.sort(list);
                list.add(0, acct.get(0));
                ret.add(list);
            }
        }
    }

    private void dfs(List<String> list, String curr) {
        if (this.visited.add(curr)) {
            list.add(curr);
            for (String each : this.graph.get(curr))
                this.dfs(list, each);
        }
    }
}