package FourthChapter;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SymbolGraph;

public class CountTestSymbolGraph {
    public static void main(String[] args) {
        String filename = args[0];
        String delim = args[1];
        edu.princeton.cs.algs4.SymbolGraph sg = new SymbolGraph(filename, delim);
        Graph G = sg.G();
        while (StdIn.hasNextLine()) {
            String source = StdIn.readLine();
            int count = 0;
            for (int w : G.adj(sg.index(source))) {
                StdOut.println("   " + sg.name(w));
                count++;
            }
            StdOut.println(source + ":" + "count:" + count);
        }
    }
}
