package us.supercheng.algorithm.data.structure.queue;

public class MyLoopQueue<E> implements Queue<E> {

    private int front;
    private int end;
    private int size;
    private E[] arr;

    public MyLoopQueue(int capacity) {
        this.arr = (E[])new Object[capacity + 1];
        this.front = 0;
        this.end = 0;
        this.size = 0;
    }

    public MyLoopQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.end;
    }

    public int getCapacity() {
        return this.arr.length -1;
    }

    @Override
    public void enqueue(E e) {
        if((this.end + 1) % this.arr.length == this.front)
            this.resize(this.getCapacity() * 2);
        this.arr[this.end] = e;
        this.end = (this.end + 1) % this.arr.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(this.isEmpty())
            throw new IllegalArgumentException("Connot Dequeue from an Empty Queue");
        E ret = this.arr[this.front];
        this.arr[this.front] = null;
        this.front = (this.front + 1) % this.arr.length;
        this.size--;
        if(this.size == this.getCapacity() / 4 && this.getCapacity() / 2 !=0)
            this.resize(this.getCapacity() / 2);
        return ret;
    }

    @Override
    public E getFront() {
        return this.arr[this.front];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("My Loop Queue Front [");
        for(int i=this.front;i!=this.end; i = (i+1)% this.arr.length)
            sb.append((i+1) % this.arr.length != this.end ? this.arr[i] + "," : this.arr[i]);
        sb.append("] End");
        return sb.toString();
    }

    private void resize(int newCapacity) {
        E[] newArr = (E[]) new Object[newCapacity + 1];
        for(int i=0;i<size;i++)
            newArr[i] = this.arr[(this.front + i) % this.arr.length];
        this.front = 0;
        this.end = size;
        this.arr = newArr;
    }
}