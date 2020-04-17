import java.io.*;
import java.util.*;

/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class FastIO extends PrintWriter {
    BufferedReader br;
    StringTokenizer st;

    public FastIO() {
        super(new BufferedOutputStream(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException  e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

public class LostMaps {
  public static class IntegerTriple implements Comparable<IntegerTriple> {
    public Integer _first, _second, _third;

    public IntegerTriple(Integer f, Integer s, Integer t) {
      _first = f;
      _second = s;
      _third = t;
    }

    public int compareTo(IntegerTriple o) {
      if (!this.first().equals(o.first()))
        return this.first() - o.first();
      else if (!this.second().equals(o.second()))
        return this.second() - o.second();
      else
        return this.third() - o.third();
    }

    Integer first() { return _first; }
    Integer second() { return _second; }
    Integer third() { return _third; }

    public String toString() { return first() + " " + second() + " " + third(); }
  }

  public static class Edge implements Comparable<Edge> {
      int u;
      int v;
      int distance;

      public Edge(int u, int v, int distance) {
          this.u = u;
          this.v = v;
          this.distance = distance;
      }

      @Override
      public int compareTo(Edge o) {
          return this.distance - o.distance;
      }
  }

  public static class UnionFind {
    public int[] p;
    public int[] rank;
    public int[] setSize;
    public int numSets;

    public UnionFind(int N) {
      p = new int[N];
      rank = new int[N];
      setSize = new int[N];
      numSets = N;
      for (int i = 0; i < N; i++) {
        p[i] = i;
        rank[i] = 0;
        setSize[i] = 1;
      }
    }

    public int findSet(int i) {
      if (p[i] == i) return i;
      else {
        p[i] = findSet(p[i]);
        return p[i];
      }
    }

    public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

    public void unionSet(int i, int j) {
      if (!isSameSet(i, j)) {
        numSets--;
        int x = findSet(i), y = findSet(j);
        // rank is used to keep the tree short
        if (rank[x] > rank[y]) {
        	p[y] = x;
        	setSize[x] = setSize[x] + setSize[y];
        }
        else {
        	p[x] = y;
        	setSize[y] = setSize[x] + setSize[y];
          if (rank[x] == rank[y])
            rank[y] = rank[y]+1;
        }
      }
    }

    public int numDisjointSets() { return numSets; }

    public int sizeOfSet(int i) { return setSize[findSet(i)]; }
  }

  public static void main(String[] args) {
    FastIO fio = new FastIO();

    int n = fio.nextInt();
    int[][] adjMatrix = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] in = fio.nextLine().split(" ");
      for (int j = 0; j < n; j++)
        adjMatrix[i][j] = Integer.parseInt(in[j]);
    }

    ArrayList<Edge> edgeList = new ArrayList<>();
    for (int i = 0; i < n; i++)
      for (int j = i + 1; j < n; j++)
        edgeList.add(new Edge(i + 1, j + 1, adjMatrix[i][j]));

    Collections.sort(edgeList);

    ArrayList<Edge> KruskalsMST = new ArrayList<>();
    UnionFind UFDS = new UnionFind(n + 1);

    for (int i = 0; i < edgeList.size(); i++) {
        Edge edge = edgeList.get(i);
        if (!UFDS.isSameSet(edge.u, edge.v)) {
            UFDS.unionSet(edge.u, edge.v);
            KruskalsMST.add(edge);
        }
    }

    for (Edge edge : KruskalsMST)
      fio.println(edge.u + " " + edge.v);

    fio.close();
  }
}
