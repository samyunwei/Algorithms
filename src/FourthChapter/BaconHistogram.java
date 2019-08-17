package FourthChapter;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.SymbolGraph;

public class BaconHistogram {
    public static void main(String[] args) {
        edu.princeton.cs.algs4.SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        Graph G = sg.G();
        String source = args[2];

        if (!sg.contains(source)) {
            StdOut.println(source + "not in database.");
            return;
        }
        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
        Graph graph = sg.G();
        ST<Integer, Integer> st = new ST<>();
        st.put(-1, 0);
        for (int i = 1; i < graph.V(); i++) {
            if (bfs.hasPathTo(i)) {
                int count = 0;
                for (int v : bfs.pathTo(i)) {
                    count++;
                }
                if (st.contains(count)) {
                    st.put(count, st.get(count) + 1);
                } else {
                    st.put(count, 1);
                }
            } else {
                st.put(-1, st.get(-1) + 1);
            }
        }
        int max = st.max();
        StdDraw.setXscale(0, 130);
        StdDraw.setYscale(0, 150);
        double x = 0;
        for (int key : st.keys()) {
            x += 10;
            double y = 0;
            double rw = 0.5 / max;
            double rh = st.get(key) / 1000;
            StdDraw.text(x, rh + 10 + x, key + "(" + st.get(key).toString() + ")");
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }
}