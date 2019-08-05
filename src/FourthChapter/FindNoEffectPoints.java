package FourthChapter;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Graph;

public class FindNoEffectPoints {

    private Bag<Integer> points;

    public FindNoEffectPoints(Graph graph) {
        int count = graph.V() - 1;
        for (int omit = 1; omit < count + 1; omit++) {
            boolean[] marked = new boolean[count + 1];
            marked[0] = true;
            dfs(graph, 0, marked, omit);
            boolean found = true;
            for (int i = 1; i < count + 1; i++) {
                if (!marked[i] && i != omit) {
                    found = false;
                    break;
                }
            }
            if (found) {
                points.add(omit);
            }
        }
    }

    private void dfs(Graph G, int v, boolean[] marked, int omitPoint) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (w == omitPoint) {
                continue;
            }
            if (!marked[w]) {
                dfs(G, w, marked, omitPoint);
            }
        }
    }
}
