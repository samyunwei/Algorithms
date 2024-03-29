package ThirdChapter;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/4/24
 */
public class HashSETint {
    private int N;
    private int M = 16;
    private int[] keys;

    public HashSETint() {
        keys = new int[M];
    }

    public HashSETint(int m) {
        M = m;
        keys = new int[M];
    }

    private int hash(int key) {
        return (new Integer(key).hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        HashSETint t;
        t = new HashSETint(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != 0) {
                t.put(keys[i]);
            }
        }
        keys = t.keys;
        M = t.M;
    }

    public void put(int key) {
        if (N >= M / 2) resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != 0; i = (i + 1) % M) {
            if (keys[i] == key) {
                return;
            }
        }
        keys[i] = key;
        N++;
    }


    public boolean contains(int key) {
        for (int i = hash(key); keys[i] != 0; i = (i + 1) % M) {
            if (keys[i] == key) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return N;
    }

    public void delete(int key) {
        if (!contains(key)) {
            return;
        }
        int i = hash(key);
        while (!(key == keys[i])) {
            i = (i + 1) % M;
        }
        keys[i] = 0;
        i = (i + 1) % M;
        while (keys[i] != 0) {
            int keyToRedo = keys[i];
            keys[i] = 0;
            N--;
            put(keyToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M / 8) {
            resize(M / 2);
        }
    }


    Iterable<Integer> keys() {
        ArrayList<Integer> reskeys = new ArrayList<Integer>();
        for (int i = 0; i < M; i++) {
            if (keys[i] != 0) {
                reskeys.add(keys[i]);
            }
        }
        return reskeys;
    }

    void showST() {
        for (int i = 0; i < M; i++) {
            if (keys[i] == 0) {
                StdOut.print(" Null ");
            } else {
                StdOut.print(" " + keys[i] + " ");
            }
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }
}
