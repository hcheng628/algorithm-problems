package us.supercheng.algorithm.problems.leetcode.peekingiterator;

import java.util.Iterator;

// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Integer nextItem;
    private Iterator<Integer> it;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.it = iterator;
        if (it.hasNext())
            this.nextItem = it.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return this.nextItem;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    @Override
    public Integer next() {
        Integer ret = this.nextItem;
        this.nextItem = it.hasNext() ? it.next() : null;
        return ret;
    }

    @Override
    public boolean hasNext() {
        return this.nextItem != null;
    }
}