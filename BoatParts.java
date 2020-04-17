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

public class BoatParts {
  public static void main(String[] args) {
    FastIO fio = new FastIO();

    int days = 1;
    int p = fio.nextInt();
    int n = fio.nextInt();
    HashSet<String> ship = new HashSet<String>();
    for (int i = 0; i < n; i++) {
      ship.add(fio.next());
      if (ship.size() == p) break;
      days++;
    }

    if (ship.size() == p) {
      fio.println(days);
    } else {
      fio.println("paradox avoided");
    }

    fio.close();
  }
}
