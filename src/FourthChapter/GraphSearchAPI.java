package FourthChapter;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.UF;

public class GraphSearchAPI {
    UF m_uf;
    int m_s;
    int m_V;
    Graph m_g;

    public GraphSearchAPI(Graph g, int s) {
        m_uf = new UF(g.V());
        m_s = s;
        for (int v = 0; v < g.V(); v++) {
            for (Integer w : g.adj(v)) {
                m_uf.union(v, w);
            }
        }
    }


    public boolean marked(int v) {
        return m_uf.connected(m_s, v);
    }

    int count() {
        int max = 0;
        for (int v = 0; v < m_V; v++) {
            int count = 0;
            for (int w = 0; w < m_V; w++) {
                if (m_uf.connected(v, w)) {
                    count++;
                }
            }
            if (max < count) {
                max = count;
            }
        }
        return max;
    }
}
