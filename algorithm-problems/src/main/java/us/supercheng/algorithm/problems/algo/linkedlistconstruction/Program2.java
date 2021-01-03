package us.supercheng.algorithm.problems.algo.linkedlistconstruction;

import java.util.*;

// Feel free to add new properties and methods to the class.
public class Program2 {

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            this.remove(node);

            if (this.head == null)
                this.head = this.tail = node;
            else {
                this.head.prev = node;
                node.next = this.head;
                this.head = node;
            }
        }

        public void setTail(Node node) {
            this.remove(node);

            if (this.tail == null)
                this.head = this.tail = node;
            else {
                this.tail.next = node;
                node.prev = this.tail;
                this.tail = node;
            }
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            this.remove(nodeToInsert);

            if (node == this.head)
                this.setHead(nodeToInsert);
            else {
                Node prev = node.prev;
                prev.next = nodeToInsert;
                nodeToInsert.prev = prev;

                nodeToInsert.next = node;
                node.prev = nodeToInsert;
            }
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            this.remove(nodeToInsert);

            if (node == this.tail)
                this.setTail(nodeToInsert);
            else {
                Node next = node.next;
                next.prev = nodeToInsert;
                nodeToInsert.next = next;

                nodeToInsert.prev = node;
                node.next = nodeToInsert;
            }
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            if (position == 1)
                this.setHead(nodeToInsert);
            else {
                Node curr = this.head;

                for (int i=2; curr != null && i<=position; i++)
                    curr = curr.next;

                if (curr == null)
                    this.setTail(nodeToInsert);
                else
                    this.insertBefore(curr, nodeToInsert);
            }
        }

        public void removeNodesWithValue(int value) {
            if (this.head == null)
                return;

            Node curr = this.head;

            while (curr != null) {
                Node next = curr.next;
                if (curr.value == value)
                    this.remove(curr);
                curr = next;
            }
        }

        public void remove(Node node) {
            if (this.head == null || node == null)
                return;

            node = this.contains(node, node.value);
            if (this.contains(this.head, node)) {
                if (node == this.head && node == this.tail)
                    this.head = this.tail = null;
                else if (node == this.head) {
                    this.head = head.next;
                    this.head.prev = null;
                } else if (node == this.tail) {
                    this.tail = tail.prev;
                    this.tail.next = null;
                } else {
                    Node prev = node.prev;
                    Node next = node.next;
                    prev.next = next;
                    next.prev = prev;
                }
                node.prev = null;
                node.next = null;
            }
        }

        public boolean containsNodeWithValue(int value) {
            return this.contains(this.head, value) != null;
        }

        private Node contains(Node curr, int value) {
            if (curr == null || curr.value == value)
                return curr;
            return contains(curr.next, value);
        }

        private boolean contains(Node curr, Node node) {
            if (curr == null)
                return false;
            return curr == node || this.contains(curr.next, node);
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}

