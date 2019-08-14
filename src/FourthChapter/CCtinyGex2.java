package FourthChapter;

import edu.princeton.cs.algs4.CC;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class CCtinyGex2 {
    public static void main(String[] args) {
        String filename = "data/algs4-data/tinyGex2.txt";
        In input = new In(filename);
        edu.princeton.cs.algs4.Graph graph = new Graph(input);
        StdOut.println(graph);
        CC cc = new CC(graph);
        StdOut.println("Connected:" + cc.count());
    }
}
