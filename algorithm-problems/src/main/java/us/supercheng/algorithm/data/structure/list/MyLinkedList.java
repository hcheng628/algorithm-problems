package us.supercheng.algorithm.data.structure.list;

//import us.supercheng.algorithm.common.helper.PrintHelper;

public class MyLinkedList<E> {

    private MyNode<E> dummyHead;
    private int size;

    public MyLinkedList() {
        this.dummyHead = new MyNode<>();
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void add(int index, E e) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Invalid Insert Position at: " + index);
        MyNode<E> node = this.dummyHead;
        for(int i=0;i<size;i++)
            node = node.next;
        MyNode<E> currNext = node.next;
        node.next = new MyNode<>(e);
        node.next.next = currNext;
        this.size++;
    }

    public void addFirst(E e) {
        this.add(0, e);
    }

    public void addLast(E e) {
        this.add(size, e);
    }

    public E get(int index) {
        //PrintHelper.echoLn("Get Index: " + index);
        MyNode<E> ret = this.dummyHead;
        for(int i=0;i<index;i++)
            ret = ret.next;
        return ret.next.val;
    }

    public E getFirst() {
        return this.get(0);
    }

    public E getLast() {
        return this.get(this.size - 1);
    }

    public void set(int index, E e) {
        MyNode<E> node = this.dummyHead;
        for(int i=0;i<index;i++)
            node = node.next;
        node.next.val = e;
    }

    public boolean contains(E e) {
        MyNode<E> node = this.dummyHead;
        while(node.next != null) {
            node = node.next;
            //PrintHelper.echoLn("Contains Curr Val: " + node.val);
            if(node.val.equals(e)){
                return true;
            }
        }
        return false;
    }

    public E remove(int index) {
        //PrintHelper.echoLn("Remove Index: " + index);
        MyNode<E> node = this.dummyHead;
        for(int i=1;i<index;i++)
            node = node.next;
        MyNode<E> delNode = node.next;
        node.next = node.next.next;
        delNode.next = null;
        this.size--;
        return delNode.val;
    }

    public E removeFirst() {
        return this.remove(0);
    }

    public E removeLast() {
        return this.remove(this.size);
    }

    public void removeElement(E e) {
        MyNode<E> node = this.dummyHead;
        int count = 0;
        while (node.next != null){
            node = node.next;
            count++;
            if(node.val.equals(e)) {
                break;
            }
        }
        this.remove(count);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        MyNode<E> node = this.dummyHead;
        sb.append("MyLinkedList: [");
        while(node.next != null) {
            node = node.next;
            sb.append(node.val + " -> ");
        }
        sb.append("Null]");
        return sb.toString();
    }
}