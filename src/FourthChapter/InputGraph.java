package FourthChapter;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class InputGraph {
    public static void main(String[] args) {
        String inputStreamName = args[0];
        In inputStream = new In(inputStreamName);
        Graph G = new Graph(inputStream);
        StdOut.println("Input Graph:");
        StdOut.println(G);
    }
}
