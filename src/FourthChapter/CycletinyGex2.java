package FourthChapter;

import edu.princeton.cs.algs4.Cycle;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class CycletinyGex2 {
    public static void main(String[] args) {
        String filename = "data/algs4-data/tinyGex2.txt";
        In input = new In(filename);
        edu.princeton.cs.algs4.Graph graph = new Graph(input);
        StdOut.println(graph);
        Cycle cycle = new Cycle(graph);
        StdOut.println(cycle.hasCycle());

    }
}
