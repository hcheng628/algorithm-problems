package us.supercheng.algorithm.algorithm.graph.mimspantrees;

public class Edge<Weight extends Number & Comparable> implements Comparable<Edge>{

    private int a;
    private int b;
    private Weight weight;

    public Edge(int a, int b, Weight weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public Edge(Edge<Weight> e) {
        this.a = e.a;
        this.b = e.b;
        this.weight = e.weight;
    }


    public int getA() {
        return this.a;
    }

    public int getB() {
        return this.b;
    }

    public Weight getWeight() {
        return this.weight;
    }

    public int other(int num) {
        return num == a ? b : a;
    }


    @Override
    public int compareTo(Edge o) {
        return this.weight.compareTo(o.weight);
    }

    @Override
    public String toString() {
        return this.a + "-" + this.b + ":" + this.weight;
    }
}