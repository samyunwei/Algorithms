package FourthChapter;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.CC;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.SymbolGraph;

public class CountMovie {
    public static void main(String[] args) {
        String filename = "data/algs4-data/movies.txt";
        String delim = "/";
        edu.princeton.cs.algs4.SymbolGraph sg = new SymbolGraph(filename, delim);
        Graph G = sg.G();
        String source = "Bacon, Kevin";
        CC cc = new edu.princeton.cs.algs4.CC(G);

        int M = cc.count();
        StdOut.println(M + " components");

        Bag<Integer>[] components;
        components = (Bag<Integer>[]) new Bag[M];

        for (int i = 0; i < M; i++) {
            components[i] = new Bag<Integer>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[cc.id(v)].add(v);
        }
        int count = 0;
        int max = 0;
        int max_index = 0;
        for (int i = 0; i < M; i++) {
            if (components[i].size() < 10) {
                count++;
            }
            if (max < components[i].size()) {
                max = components[i].size();
                max_index = i;
            }
        }
        StdOut.println(count);
        StdOut.println("max:" + max + "index:" + max_index);
        int diameter = 1;
        int radius = -1;
        int center = -1;
        int find_index = sg.index("Bacon, Kevin");
        boolean find = false;
        for (int s : components[max_index]) {
            if (s == find_index) {
                find = true;
            }
            BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
            int eccentricity = 0;
            for (int s_d : components[max_index]) {
                if (s_d != s) {
                    for (int temp : bfs.pathTo(s_d)) {
                        eccentricity++;
                    }
                }
            }
            StdOut.println("calc:" + s + "eccentricity:" + eccentricity + "find:" + find);

            if (diameter == 1 || diameter < eccentricity) {
                diameter = eccentricity;
            }
            if (radius == -1 || radius > eccentricity) {
                radius = eccentricity;
                center = s;
            }
            StdOut.println("diameter:" + diameter + "radius:" + radius + "center:" + center);
        }
        StdOut.println("diameter:" + diameter + "radius:" + radius + "center:" + center);
        StdOut.println("Kevin Bacon in connect:" + find);
    }
}

