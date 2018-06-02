package us.supercheng.algorithm.data.structure.stack;

import us.supercheng.algorithm.data.structure.array.MyArray;

public class MyArrayStack<E> implements Stack<E>{

    private MyArray<E> array;

    public MyArrayStack() {
        this.array = new MyArray<>();
    }

    @Override
    public int getSize() {
        return this.array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    @Override
    public void push(E e) {
        this.array.addLast(e);
    }

    @Override
    public E pop() {
        return this.array.removeLast();
    }

    @Override
    public E peek() {
        return this.array.get(this.array.getSize()-1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyArrayStack Bottom [");
        for(int i=0;i<this.array.getSize();i++)
            sb.append(i == this.array.getSize() -1 ? this.array.get(i) : this.array.get(i) + ",");
        sb.append("] Top");
        return sb.toString();
    }
}