package us.supercheng.algorithm.problems.lrucache;

import java.util.*;

public class LRUCache {

    private int cap_;
    private List<Integer> list;
    private Map<Integer, Integer> map_;

    public LRUCache(int capacity, int slowList) {
        this.cap_ = capacity;
        this.list = new ArrayList<>();
        this.map_ = new HashMap<>();
    }

    public int get_(int key) {
        int ret = -1;

        if (this.map.containsKey(key)) {
            ret = this.map_.get(key);
            this.list.remove(this.list.indexOf(key));   // optimize
            this.list.add(key);
        }

        return ret;
    }

    public void put_(int key, int value) {
        if (this.map_.containsKey(key))
            this.list.remove(this.list.indexOf(key));  // optimize
        else
        if (this.list.size() + 1 > this.cap_)
            this.map_.remove(this.list.remove(0));

        this.list.add(key);
        this.map_.put(key, value);
    }

    // Slow List + Map Approach Above ------ Fast Double-Linked List Map Approach Below

    private int cap;
    private Node first;
    private Node last;
    private HashMap<Integer, Node> map;
    private boolean debug;

    public LRUCache(int capacity) {
        this.debug = false;
        this.cap = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        Node ret = this.map.get(key);
        if (ret == null)
            return -1;

        if (ret != this.last) {
            if (ret == this.first)
                this.first = this.first.next;
            else {
                if (ret.prev != null)
                    ret.prev.next = ret.next;
                if (ret.next != null)
                    ret.next.prev = ret.prev;
            }

            this.last.next = ret;
            ret.prev = this.last;
            this.last = ret;
            this.align();
        }
        // this.debugAll("GET METHOD --- HC: DEBUG");
        return ret.val;
    }

    public void put(int key, int value) {
        Node n = this.map.get(key);

        if (n == null && this.map.size() + 1 > this.cap) {
            this.map.remove(this.first.key);
            this.first = this.first.next;
        }

        if (n == null)
            n = new Node(key, value);
        else {
            n.val = value;
            this.map.put(key, n);
            this.get(key);  // reuse logic
            return;
        }

        if (n != this.last) {
            if (this.last != null) {
                this.last.next = n;
                n.prev = this.last;
            }

            if (this.first == null)
                this.first = n;
            this.last = n;
            this.map.put(key, n);
            this.align();
            // this.debugAll("PUT METHOD --- HC: DEBUG");
        }
    }

    class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public String toString() {
            return (this.prev != null ? this.prev.key : "null") + " <- [" + this.key + "(" + this.val +")] -> " + (this.next != null ? this.next.key : "null");
        }
    }

    private void align() {
        if (this.first != null && this.first.prev != null)
            this.first.prev = null;
        if (this.last != null && this.last.next != null)
            this.last.next = null;
    }


    private void debugAll(String msg) {
        if (this.debug) {
            this.printFandL(msg);
            this.printPointersInfo();
            this.printM(msg);
        }
    }

    private void printPointersInfo() {
        if (this.debug) {
            StringBuilder sb = new StringBuilder();
            sb.append("First to Last ");

            for (Node head = this.first; head != null; head = head.next)
                sb.append(head.key + " -> ");
            System.out.println(sb.toString() + " Done!");

            sb.setLength(0);
            sb.append("Last to First ");
            for (Node tail = this.last; tail != null; tail = tail.prev)
                sb.append(tail.key + " -> ");
            System.out.println(sb.toString() + "Done Done!\n");
        }
    }

    private void printM(String s) {
        if (this.debug) {
            System.out.println("***** Begin: " + s + " *****");
            for (Map.Entry<Integer, Node> e : this.map.entrySet())
                System.out.println("key: " + e.getKey() + " val: " + e.getValue().val);
            System.out.println("##### End " + s + "#####");
        }
    }

    private void printFandL(String msg) {
        if (this.debug)
            System.out.println(msg + "\n" + this.first + "\n" + this.last);
    }

}