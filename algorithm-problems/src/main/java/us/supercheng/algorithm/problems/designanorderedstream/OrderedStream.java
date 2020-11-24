package us.supercheng.algorithm.problems.designanorderedstream;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {

    private String[] arr;
    private int prt;
    private int L;

    public OrderedStream(int n) {
        this.prt = 1;
        this.L = n + 1;
        this.arr = new String[this.L];
    }

    public List<String> insert(int id, String value) {
        List<String> ret = new ArrayList<>();
        this.arr[id] = value;

        while (this.prt < this.L && this.arr[this.prt] != null)
            ret.add(this.arr[this.prt++]);

        return ret;
    }
}