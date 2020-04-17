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

class UnionFindDS {
  public int[] p;
  public int[] rank;
  public int[] size;
  public int[] items;
  public int numSets;

  public UnionFindDS(int n) {
    p = new int[n];
    rank = new int[n];
    size = new int[n];
    items = new int[n];
    numSets = n;

    for (int i = 0; i < n; i++) {
      p[i] = i;
      rank[i] = 0;
      size[i] = 1;
    }
  }

  public boolean isSameSet(int i, int j) {
    return findSet(i) == findSet(j);
  }

  public int findSet(int i) {
    if (p[i] == i) {
      return i;
    } else {
      p[i] = findSet(p[i]);
      return p[i];
    }
  }

  public void unionSet(int i, int j) {
    if (!isSameSet(i, j)) {
      numSets--;
      int x = findSet(i);
      int y = findSet(j);

      if (rank[x] > rank[j]) {
        p[y] = x;
        size[x] += size[y];
        items[x] += items[y];
      } else {
        p[x] = y;
        if (rank[x] == rank[y]) {
          rank[y] = rank[x]++;
        }
        size[y] += size[x];
        items[y] += items[x];
      }
    }
  }

}

public class Ladice {
  public static void main(String[] args) {
    FastIO fio = new FastIO();

    int n = fio.nextInt();
    int l = fio.nextInt();
    UnionFindDS drawer = new UnionFindDS(l);

    for (int i = 0; i < n; i++) {
      int a = fio.nextInt() - 1;
      int b = fio.nextInt() - 1;

      drawer.unionSet(a, b);
      int predecessor = drawer.findSet(a);

      if (drawer.size[predecessor] > drawer.items[predecessor]) {
        fio.println("LADICA");
        drawer.items[predecessor]++;
      } else {
        fio.println("SMECE");
      }
    }

    fio.close();
  }
}
