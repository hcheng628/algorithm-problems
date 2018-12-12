package us.supercheng.algorithm.common.entity;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        this.label = x;
        this.neighbors = new ArrayList<>();
    }
}