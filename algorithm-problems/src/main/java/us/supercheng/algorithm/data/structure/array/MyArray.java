package us.supercheng.algorithm.data.structure.array;

public class MyArray<E> {

    private E[] data;
    private int size;

    public MyArray(int size) {
        this.data = (E[]) new Object[size];
        this.size = 0;
    }

    public MyArray() {
        this(10);
    }

    public int getCapacity() {
        return this.data.length;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E newE) {
        if (index > this.data.length - 1 || index < 0)
            throw new IllegalArgumentException("Invalid Insert Index Position at " + index);
        if (size + 1 == this.getCapacity())
            this.resize(this.getCapacity() * 2);
        for (int i = size + 1; i > index; i--)
            this.data[i] = this.data[i - 1];
        this.data[index] = newE;
        this.size++;
    }

    public E remove(int index) {
        if (index > this.data.length - 1 || index < 0)
            throw new IllegalArgumentException("Invalid Remove Index Position at " + index);
        E ret = this.data[index];
        for (int i = index; i < size; i++)
            this.data[i] = this.data[i + 1];
        if(size != 0)
            this.size--;
        int capacity = this.getCapacity();
        if (size * 4 == capacity && capacity / 2 != 0)
            this.resize(capacity / 2);
        return ret;
    }

    public E get(int index) {
        if (index > this.data.length - 1 || index < 0)
            throw new IllegalArgumentException("Invalid Get --- Index Position at " + index);
        return this.data[index];
    }

    public void set(int index, E newE) {
        if (index > this.data.length - 1 || index < 0)
            throw new IllegalArgumentException("Invalid Insert --- Index Position");
        this.data[index] = newE;
    }

    public boolean contains(E element) {
        if (size == 0)
            return false;
        for (int i = 0; i < size; i++)
            if (this.data[i].equals(element))
                return true;
        return false;
    }

    public int find(E element) {
        if (size == 0)
            return -1;
        for (int i = 0; i < size; i++)
            if (this.data[i].equals(element))
                return i;
        return -1;
    }

    public void addLast(E newE) {
        this.add(this.size, newE);
    }

    public void addFirst(E newE) {
        this.add(0, newE);
    }

    public E removeFirst() {
        return this.remove(0);
    }

    public E removeLast() {
        return this.remove(size);
    }

    public void removeElement(E removeE) {
        if (size == 0)
            throw new IllegalArgumentException("Empty MyArray No Element to Remove");
        for (int i = 0; i < size; i++)
            if (this.data[i].equals(removeE))
                remove(i);
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < this.size; i++)
            newData[i] = this.data[i];
        this.data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyArray: Size: " + size + " Capacity: " + this.data.length + " [");
        for (int i = 0; i < size; i++)
            sb.append(i == size - 1 ? this.data[i] + "]" : this.data[i] + ",");
        return sb.toString();
    }
}