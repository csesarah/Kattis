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

public class Islands3 {
  public static void dfs(char[][] grid, boolean[][] visited, int r, int c) {
    visited[r][c] = true;

    if (r - 1 >= 0) {// up
      if (visited[r - 1][c] == false && (grid[r - 1][c] == 'C' || grid[r - 1][c] == 'L'))
          dfs(grid, visited, r - 1, c);
    }

    if (r + 1 < grid.length) {// down
      if (visited[r + 1][c] == false && (grid[r + 1][c] == 'C' || grid[r + 1][c] == 'L'))
          dfs(grid, visited, r + 1, c);
    }

    if (c - 1 >= 0) {// left
      if(visited[r][c - 1] == false && (grid[r][c - 1] == 'C' || grid[r][c - 1] == 'L'))
          dfs(grid, visited, r, c - 1);
    }

    if (c + 1 < grid[r].length) {// right
      if (visited[r][c + 1] == false && (grid[r][c + 1] == 'C' || grid[r][c + 1] == 'L'))
          dfs(grid, visited, r, c + 1);
    }

  }

  public static void main(String[] args) {
    FastIO fio = new FastIO();

    int r = fio.nextInt();
    int c = fio.nextInt();
    char[][] grid = new char[r][c];
    boolean[][] visited = new boolean[r][c];
    int count = 0;

    for (int i = 0; i < r; i++) {
      char[] in = fio.next().toCharArray();
      for (int j = 0; j < c; j++) {
        grid[i][j] = in[j];
      }
    }

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (grid[i][j] == 'L' && visited[i][j] == false) {// is land & not visited
          dfs(grid, visited, i, j);
          count++;
        }
      }
    }
    fio.println(count);

    fio.close();
  }
}
