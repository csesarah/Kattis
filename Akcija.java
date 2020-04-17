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

public class Akcija {
  public static void main(String[] args) {
    FastIO fio = new FastIO();

    int[] books = new int[fio.nextInt()];
    int total = 0;

    for (int i = 0; i < books.length; i++) {
      books[i] = fio.nextInt();
      total += books[i];
    }

    Arrays.sort(books);

    for (int i = books.length - 3; i >= 0; i -= 3) {
      total -= books[i];
    }

    fio.println(total);
    fio.close();
  }
}
