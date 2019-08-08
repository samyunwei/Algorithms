package FourthChapter;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;


public class GraphProperties {
    private int diameter;
    private int radius;
    private int center;
    private int girth;
    private int connectedCount;
    private Graph m_Graph;

    public GraphProperties(Graph graph) throws Exception {
        m_Graph = graph;
        calc();
        if (connectedCount < m_Graph.V()) {
            throw new Exception("not Connected !");
        }
    }


    int eccentricity(int s) {
        boolean[] marked = new boolean[m_Graph.V()];
        int[] edgeTo = new int[m_Graph.V()];
        int[] pathslen = new int[m_Graph.V()];
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] = true;
        queue.enqueue(s);
        int eccentricity = 0;
        connectedCount = 1;
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : m_Graph.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    connectedCount++;
                    marked[w] = true;
                    pathslen[w] = connectedCount;
                    queue.enqueue(w);
                } else {
                    if (w != s && girth < eccentricity + pathslen[w] + 1) {
                        girth = eccentricity + pathslen[w] + 1;
                    }
                }
            }
            eccentricity++;
        }
        return eccentricity;
    }

    int diameter() {
        calc();
        return diameter;
    }

    int radius() {
        calc();
        return radius;
    }

    int center() {
        calc();
        return center;
    }

    int girth() {
        calc();
        return girth;
    }

    private void calc() {
        for (int i = 0; i < m_Graph.V(); i++) {
            int eccentricity = eccentricity(i);
            if (i == 0) {
                diameter = eccentricity;
                radius = eccentricity;
            }

            if (diameter < eccentricity) {
                diameter = eccentricity;
            }
            if (radius > eccentricity) {
                radius = eccentricity;
                center = i;
            }
        }
    }

}

