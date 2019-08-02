package FourthChapter;

import edu.princeton.cs.algs4.DepthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DFStinyGex2 {
    public static void main(String[] args) {
        String filename = "data/algs4-data/tinyGex2.txt";
        In input = new In(filename);
        Graph graph = new Graph(input);
        StdOut.println(graph);
        DepthFirstPaths dfs = new DepthFirstPaths(graph, 0);
        for (int v = 1; v < graph.V(); v++) {
            if (!dfs.hasPathTo(v)) {
                continue;
            }
            if (v >= 2) {
                StdOut.println("");
            }
            StdOut.printf("Path to %s: ", v);
            for (int step : dfs.pathTo(v)) {
                StdOut.printf("%s ", step);
            }
        }
    }
}
