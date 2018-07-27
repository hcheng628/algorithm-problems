package us.supercheng.algorithm.problems.designlinkedlist;

public class App {

    private int [] arr;
    private int size;

    /** Initialize your data structure here. */
    public App() {
        this.arr = new int [1001];
        this.size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index > this.size - 1)
            return -1;
        return arr[index];
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        for(int i=this.size;i>=1;i--)
            this.arr[i] = this.arr[i-1];
        this.arr[0]=val;
        this.size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        this.arr[size] = val;
        this.size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index == 0)
            this.addAtHead(val);
        else if(index == this.size)
            this.addAtTail(val);
        else if (index > 0 && index < this.size) {
            for(int i=this.size-1;i>=index;i--)
                this.arr[i+1] = this.arr[i];
            this.arr[index]=val;
            this.size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >=0 && index < this.size) {
            for(int i=index;i<this.size;i++)
                this.arr[i] = this.arr[i+1];
            this.size--;
        }
    }
}