package FourthChapter;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestNewGraph {
    public static void main(String[] args) {
        String filename = args[0];
        String delim = args[1];
        Graph graph = new Graph(filename, delim);
        StdOut.println(graph.Print());
    }
}
