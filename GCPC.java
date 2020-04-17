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

class GCPCTeam implements Comparable<GCPCTeam> {
  public int teamNumber;
  public int solved;
  public int penalty;

  public GCPCTeam(int teamNumber) {
    this.teamNumber = teamNumber;
    this.solved = 0;
    this.penalty = 0;
  }

  public void problems(int x) {
    this.solved++;
    this.penalty += x;
  }

  @Override
  public int compareTo(GCPCTeam o) {
    if (this.solved > o.solved) {
      return 1;
    } else if (this.solved < o.solved) {
      return -1;
    } else {
      if (this.penalty < o.penalty) {
        return 1;
      } else if (this.penalty > o.penalty) {
        return -1;
      } else {
        return o.teamNumber - this.teamNumber;
      }
    }
  }
}

class Vertex {
  Vertex parent, left, right;
  GCPCTeam key;
  int height;
  int size;

  public Vertex(GCPCTeam team) {
    key = team;
    parent = left = right = null;
    height = 0;
    size = 1;
  }

  public void updateHeight() {
    if (this.left == null && this.right == null) {
      this.height = 1;
    } else if (this.left == null) {
      this.height = this.right.height + 1;
    } else if (this.right == null) {
      this.height = this.left.height + 1;
    } else {
      this.height = Math.max(this.left.height, this.right.height) + 1;
    }
  }

  public void updateSize() {
    if (this.left == null && this.right == null) {
      this.size = 1;
    } else if (this.left == null) {
      this.size = this.right.size + 1;
    } else if (this.right == null) {
      this.size = this.left.size + 1;
    } else {
      this.size = this.left.size + this.right.size + 1;
    }
  }
}

class AVL {
  public Vertex root;

  public AVL() {
    root = null;
  }

  public GCPCTeam search(GCPCTeam v) {
    Vertex res = search(root, v);
    return res == null ? null : res.key;
  }

  public Vertex search(Vertex T, GCPCTeam v) {
    if (T == null) return null;

    if (v.compareTo(T.key) > 0) {
      return search(T.right, v);
    } else if (v.compareTo(T.key) < 0) {
      return search(T.left, v);
    } else {
      return T;
    }
  }

  public GCPCTeam findMin() { return findMin(root); }

  public GCPCTeam findMin(Vertex T) {
    if (T.left == null) {
      return T.key;
    } else {
      return findMin(T.left);
    }
  }

  public GCPCTeam successor(GCPCTeam v) {
    Vertex vPos = search(root, v);
    if (vPos == null) {
      return null;
    } else {
      return successor(vPos);
    }
  }

  public GCPCTeam successor(Vertex T) {
    if (T.right != null) {
      return findMin(T.right);
    } else {
      Vertex par = T.parent;
      Vertex cur = T;

      while ((par != null) && (cur.key.teamNumber == par.right.key.teamNumber)) {
        cur = par;
        par = cur.parent;
      }

      return par == null ? null : par.key;
    }
  }

  public void insert(GCPCTeam v) { root = insert(root, v); }

  public Vertex insert(Vertex T, GCPCTeam v) {
    if (T == null) {
      return new Vertex(v);
    }

    if (v.compareTo(T.key) > 0) {
      T.right = insert(T.right, v);
      T.right.parent = T;
    } else {
      T.left = insert(T.left, v);
      T.left.parent = T;
    }

    T.updateHeight();
    T.updateSize();
    T = balance(T);

    return T;
  }

  public void delete(GCPCTeam v) { root = delete(root, v); }

  public Vertex delete(Vertex T, GCPCTeam v) {
    if (T == null) return null;

    if (v.compareTo(T.key) < 0) {
        T.left = delete(T.left, v);
    } else if (v.compareTo(T.key) > 0) {
        T.right = delete(T.right, v);
    } else {
      if (T.left == null && T.right == null) {
        T = null;
      } else if (T.left == null && T.right != null) {
        T.right.parent = T.parent;
        T = T.right;
      } else if (T.left != null && T.right == null) {
        T.left.parent = T.parent;
        T = T.left;
      } else {
        GCPCTeam successorV = successor(v);
        T.key = successorV;
        T.right = delete(T.right, successorV);
      }
    }

    if (T != null) {
      T.updateHeight();
      T.updateSize();
      T = balance(T);
    }

    return T;
  }

  public Vertex rotateRight(Vertex T) {
    if (T == null) return null;

    Vertex w = T.left;
    if (w == null) {
      return null;
    }
    w.parent = T.parent;
    if (T.parent == null) {
      root = w;
    }
    T.parent = w;
    T.left = w.right;
    if (w.right != null) {
      w.right.parent = T;
    }
    w.right = T;

    T.updateHeight();
    T.updateSize();
    w.updateHeight();
    w.updateSize();

    return w;
  }

  public Vertex rotateLeft(Vertex T) {
    if (T == null) return null;

    Vertex w = T.right;
    if (w == null) {
      return null;
    }
    w.parent = T.parent;
    if (T.parent == null) {
      root = w;
    }
    T.parent = w;
    T.right = w.left;
    if (w.left != null) {
      w.left.parent = T;
    }
    w.left = T;

    T.updateHeight();
    T.updateSize();
    w.updateHeight();
    w.updateSize();

    return w;
  }

  public int bf(Vertex T) {
    if (T == null) {
        return 0;
    }
    int left = 0;
    int right = 0;
    if (T.left == null && T.right == null) {
      return 0;
    } else if (T.left != null && T.right == null) {
      return T.left.height - 0;
    } else if (T.left == null && T.right != null) {
      return 0 - T.right.height;
    }

    return T.left.height - T.right.height;
  }

  public Vertex balance(Vertex T) {
    if (bf(T) == 2) {
      if (bf(T.left) == -1) {
        T.left = rotateLeft(T.left);
      }
      T = rotateRight(T);
    } else if (bf(T) == -2) {
      if (bf(T.right) == 1) {
        T.right = rotateRight(T.right);
      }
      T = rotateLeft(T);
    }
    return T;
  }

  public int rank(Vertex T, GCPCTeam v) {
    if (v.compareTo(T.key) < 0) {
      return rank(T.left, v);
    } else if (v.compareTo(T.key) > 0) {
      if (T.left == null) {
        return rank(T.right, v) + 1;
      }

      return T.left.size + 1 + rank(T.right, v);
    } else {
      if (T.left == null) {
        return 1;
      }

      return T.left.size + 1;
    }
  }
}

public class GCPC {
  public static void main(String[] args) {
    FastIO fio = new FastIO();

    AVL gcpc = new AVL();
    int n = fio.nextInt();
    int m = fio.nextInt();

    GCPCTeam[] teams = new GCPCTeam[n + 1];
    for (int i = 1; i <= n; i++) {
      teams[i] = new GCPCTeam(i);
      gcpc.insert(teams[i]);
    }

    for (int i = 0; i < m; i++) {
      int t = fio.nextInt();
      int p = fio.nextInt();

      gcpc.delete(teams[t]);
      teams[t].problems(p);
      gcpc.insert(teams[t]);
      fio.println(n - gcpc.rank(gcpc.root, teams[1]) + 1);
    }

    fio.close();
  }
}
