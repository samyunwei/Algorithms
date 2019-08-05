package FourthChapter;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Graph;

import java.util.stream.IntStream;

public class BFStinyGex2 {
    public static void main(String[] args) {
        String filename = "data/algs4-data/tinyGex2.txt";
        In input = new In(filename);
        edu.princeton.cs.algs4.Graph graph = new Graph(input);
        StdOut.println(graph);
        edu.princeton.cs.algs4.BreadthFirstPaths dfs = new BreadthFirstPaths(graph, 0);
        IntStream.range(1, graph.V()).filter(dfs::hasPathTo).forEach(v -> {
            if (v >= 2) {
                StdOut.println("");
            }
            StdOut.printf("Path to %s: ", v);
            for (int step : dfs.pathTo(v)) {
                StdOut.printf("%s ", step);
            }
        });
    }
}
