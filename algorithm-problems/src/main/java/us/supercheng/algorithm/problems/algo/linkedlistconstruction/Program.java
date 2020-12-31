package us.supercheng.algorithm.problems.algo.linkedlistconstruction;

import java.util.*;

// Feel free to add new properties and methods to the class.
public class Program {

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            if (node == head)
                return;

            if (node == tail) {
                node.prev.next = null;
                tail = node.prev;

                node.next = head;
                head.prev = node;
                head = node;
                head.prev = null;
            } else if (head == null)
                head = tail = node;
            else {
                if (contains(node))
                    remove(node);

                node.next = head;
                head.prev = node;

                head = node;
                head.prev = null;
            }
        }

        public void setTail(Node node) {
            if (node == tail)
                return;

            if (node == head) {
                head = node.next;
                head.prev = null;

                node.prev = tail;
                node.next = null;
                tail.next = node;
                tail = node;
            } else if (tail == null)
                head = tail = node;
            else {
                if (contains(node))
                    remove(node);

                tail.next = node;
                node.prev = tail;

                tail = node;
                tail.next = null;
            }
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            if (contains(nodeToInsert))
                remove(nodeToInsert);

            Node prev = node.prev;
            if (prev != null)
                prev.next = nodeToInsert;

            nodeToInsert.prev = prev;
            nodeToInsert.next = node;
            node.prev = nodeToInsert;

            if (nodeToInsert.prev == null)
                head = nodeToInsert;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            if (contains(nodeToInsert))
                remove(nodeToInsert);

            Node next = node.next;
            if (next != null)
                next.prev = nodeToInsert;

            nodeToInsert.next = next;
            node.next = nodeToInsert;
            nodeToInsert.prev = node;

            if (nodeToInsert.next == null)
                tail = nodeToInsert;
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            position--;
            Node curr = head;

            for (int i=0; i<position; i++)
                curr = curr.next;

            if (contains(nodeToInsert))
                remove(nodeToInsert);

            if (curr == head) {
                nodeToInsert.next = head;
                nodeToInsert.prev = null;
                if (head != null)
                    head.prev = nodeToInsert;
                head = nodeToInsert;
            } else if (curr == tail) {
                tail.prev.next = nodeToInsert;
                nodeToInsert.prev = tail.prev;

                nodeToInsert.next = tail;
                tail.prev = nodeToInsert;
            } else {
                Node prev = curr.prev;
                curr.prev = nodeToInsert;
                nodeToInsert.next = curr;
                prev.next = nodeToInsert;
                nodeToInsert.prev = prev;
            }

            if (head == null)
                head = nodeToInsert;
            if (tail == null)
                tail = nodeToInsert;
        }

        private boolean contains(Node node) {
            if (head == null)
                return false;

            Node curr = head;
            while (curr != null && curr != node)
                curr = curr.next;

            return curr != null;
        }

        public void removeNodesWithValue(int value) {
            for (Node curr = head, next = null; curr != null; curr = next) {
                next = curr.next;
                if (curr.value == value)
                    remove(curr);
            }
        }

        public void remove(Node node) {
            if (node == head)
                head = node.next;

            if (node == tail)
                tail = node.prev;

            Node prev = node.prev;
            Node next = node.next;

            if (next != null)
                next.prev = prev;
            if (prev != null)
                prev.next = next;
        }

        public boolean containsNodeWithValue(int value) {
            for (Node curr = head; curr != null; curr = curr.next)
                if (curr.value == value)
                    return true;

            return false;
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


