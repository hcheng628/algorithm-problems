package us.supercheng.algorithm.problems.flattennestedlistiterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new Stack<>();
        for (int i=nestedList.size()-1;i>=0;i--)
            this.stack.push(nestedList.get(i));
    }

    @Override
    public Integer next() {
        return this.stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        if (this.stack.isEmpty())
            return false;

        if (this.stack.peek().isInteger()) {
            this.stack.push(this.stack.pop());
            return true;
        } else {
            List<NestedInteger> list = this.stack.pop().getList();
            for (int i=list.size()-1;i>=0;i--)
                if (list.get(i)!= null)
                    this.stack.push(list.get(i));
            return this.hasNext();
        }
    }
}