package ThirdChapter;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

/**
 * Author:Sam
 * Mail:samyunwei@163.com
 * Create Time: 2017/4/2
 */
public class LinerProbingHashSTCount<Key, Value> {
    private int N;
    private int M = 16;
    private Key[] keys;
    private Value[] vals;

    public LinerProbingHashSTCount() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    public LinerProbingHashSTCount(int m) {
        M = m;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        LinerProbingHashSTCount<Key, Value> t;
        t = new LinerProbingHashSTCount<Key, Value>(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                t.put(keys[i], vals[i]);
            }
        }
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    public void put(Key key, Value val) {
        if (N >= M / 2) resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }


    private int getCount(Key key) {
        int count = 0;
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            ++count;
            if (keys[i].equals(key)) {
                return count;
            }
        }
        return count;
    }


    public double getFindedAvr() {
        int total = 0;
        Iterable<Key> thekeys = this.Keys();
        for (Key key : thekeys) {
            total = getCount(key);
        }
        return total / N;
    }

    public double getNoFoundedAvr(Key[] nokeys) {
        int total = 0;
        for (Key each : nokeys) {
            total += getCount(each);
        }
        return total / nokeys.length;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }


    public void delete(Key key) {
        if (!contains(key)) {
            return;
        }
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M / 8) {
            resize(M / 2);
        }
    }


    Iterable<Key> Keys() {
        ArrayList<Key> reskeys = new ArrayList<Key>();
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                reskeys.add(keys[i]);
            }
        }
        return reskeys;
    }

    void showST() {
        for (int i = 0; i < M; i++) {
            if (keys[i] == null) {
                StdOut.print(" Null ");
            } else {
                StdOut.print(" " + keys[i] + " ");
            }
        }
    }
}
