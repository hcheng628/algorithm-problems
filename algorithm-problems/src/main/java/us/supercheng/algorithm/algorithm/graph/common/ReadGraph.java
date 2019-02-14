package us.supercheng.algorithm.algorithm.graph.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadGraph {

    private Scanner scanner;

    public ReadGraph(Graph graph, String filename) {
        this.readFile(filename);
        try {
            int vertexes = this.scanner.nextInt(),
                edges = this.scanner.nextInt();
            if (vertexes < 0 || edges < 0)
                throw new IllegalArgumentException("number of vertexes and edges in a Graph must be nonnegative");

            for (int i=0;i<edges;i++) {
                int from = this.scanner.nextInt();
                int to = this.scanner.nextInt();
                graph.addEdge(from, to);
            }
        } catch (InputMismatchException imE) {
            throw new InputMismatchException("attempts to read an 'int' value from input stream, but the next token is \"" + scanner.next() + "\"");
        } catch (NoSuchElementException nseE) {
            throw new NoSuchElementException("attempts to read an 'int' value from input stream, but there are no more tokens available");
        }
    }

    private void readFile(String filename) {
        try {
            File file = new File(filename);
            if (file.exists()) {
                this.scanner = new Scanner(new BufferedInputStream(new FileInputStream(file)), "UTF-8");
                this.scanner.useLocale(Locale.US);
            } else
                throw new IllegalArgumentException(filename + "doesn't exist.");
        } catch (Exception ex) {
            throw new IllegalArgumentException("Could not open " + filename, ex);
        }
    }
}