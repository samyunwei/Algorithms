package FourthChapter;


import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

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
}
