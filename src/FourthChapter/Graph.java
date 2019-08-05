package FourthChapter;


import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.Map;


/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/6/6
 */
public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int v) {
        this.V = v;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public Graph(String stream, String sp) {
        In in = new In(stream);
        this.V = in.readInt();
        this.E = in.readInt();
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>();
        }

        while (in.hasNextLine()) {
            String line = in.readLine();
            if (line.isEmpty()) {
                continue;
            }
            String[] a = line.split(sp);
            int v = Integer.parseInt(a[0]);
            for (int i = 1; i < a.length; i++) {
                addEdge(v, Integer.parseInt(a[i]));
            }
        }
    }


    Graph Copy() {
        Graph copy_item = new Graph(this.V);
        copy_item.E = this.E;
        System.arraycopy(this.adj, 0, copy_item.adj, 0, this.E);
        return copy_item;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public void addEdgeNoLoop(int v, int w) {
        if (v == w) {
            return;
        }
        for (Integer node : adj[w]
        ) {
            if (node == v) {
                return;
            }
        }
        addEdge(v, w);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    Boolean hasEdge(int v, int w) {
        for (Integer i : adj[v]) {
            if (i == w) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v)) {
                s += w + " ";
                s += "\n";
            }
        }
        return s;
    }


    public String Print() {
        Map<String, Boolean> marked = new HashMap<String, Boolean>();
        StringBuilder s = new StringBuilder(V + " vertices, " + E + " edges\n");
        for (Integer v = 0; v < V; v++) {
            s.append(v).append(": ");
            for (Integer w : this.adj(v)) {
                if (marked.containsKey(w.toString() + v.toString()) || marked.containsKey(v.toString() + w.toString())) {
                    s.append("*").append(w).append("*").append(" ");
                } else {
                    s.append(w).append(" ");
                    marked.put(w.toString() + v.toString(), true);
                    marked.put(v.toString() + w.toString(), true);
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

}
