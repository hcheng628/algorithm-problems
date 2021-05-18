package us.supercheng.algorithm.problems.algo.lrucache;

import java.util.HashMap;
import java.util.Map;

public class Program {

    static class LRUCache {
        int maxSize;
        Map<String, Node> map;
        Node top;
        Node bot;

        public LRUCache(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
            this.map = new HashMap<>();
        }

        public void insertKeyValuePair(String key, int value) {
            Node n = null;

            if (this.map.containsKey(key)) {
                n = this.map.get(key);
                if (n.val != value)
                    n.val = value;
            } else {
                n = new Node(null, null, key, value);
                if (this.map.size() == this.maxSize)
                    this.removeLRU();
                this.map.put(key, n);
            }

            this.markMostLRU(n);
        }

        private void removeLRU() {
            if (this.bot == null)
                return;

            Node remNode = this.bot;
            this.bot = this.bot.next;
            if (this.bot != null)
                this.bot.prev = null;

            remNode.prev = null;
            remNode.next = null;
            if (this.map.containsKey(remNode.key))
                this.map.remove(remNode.key);
        }

        private void markMostLRU(Node n) {
            if (this.bot == null)
                this.bot = n;

            if (this.top == n)
                return;

            if (this.top != null) {
                Node prevN = n.prev;
                Node nextN = n.next;

                if (prevN != null)
                    prevN.next = nextN;
                if (nextN != null)
                    nextN.prev = prevN;

                n.prev = null;
                n.next = null;

                this.top.next = n;
                n.prev = this.top;
            }
            this.top = n;
        }

        public LRUResult getValueFromKey(String key) {
            Node n = this.map.get(key);
            if (n == null)
                return null;

            if (this.bot == n)
                this.bot = n.next;

            this.markMostLRU(n);
            return new LRUResult(true, n.val);
        }

        public String getMostRecentKey() {
            return this.top == null ? null : this.top.key;
        }
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }

    static class Node {
        Node prev;
        Node next;
        String key;
        int val;

        public Node(Node prev, Node next, String key, int val) {
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.val = val;
        }
    }
}
