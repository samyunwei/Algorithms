package FourthChapter;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.SymbolGraph;

public class DegreeOfSeparartionY {
    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        Graph G = sg.G();
        String source = args[2];
        int year = Integer.parseInt(args[3]);

        if (!sg.contains(source)) {
            StdOut.println(source + "not in database.");
            return;
        }
        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        while (!StdIn.isEmpty()) {
            String sink = StdIn.readLine();
            if (sg.contains(sink)) {
                int t = sg.index(sink);
                if (bfs.hasPathTo(t)) {
                    for (int v : bfs.pathTo(t)) {
                        int index_beg = sg.name(v).indexOf("(");
                        int index_end = sg.name(v).indexOf(")");
                        if (index_beg != -1 && index_end != -1) {
                            try {
                                int match_year = Integer.parseInt(sg.name(v).substring(index_beg + 1, index_end));
                                if (match_year < year) {
                                    continue;
                                }
                            } catch (NumberFormatException e) {
                            }
                        }
                        StdOut.println("  " + sg.name(v));
                    }
                } else {
                    StdOut.println("Not Connected");
                }
            } else {
                StdOut.println("Not in database");
            }
        }
    }
}
