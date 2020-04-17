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

public class Conformity {
  public static void main(String[] args) {
    FastIO fio = new FastIO();

    HashMap<String, Integer> frosh = new HashMap<String, Integer>();
    ArrayList<String> list = new ArrayList<String>();

    int n = fio.nextInt();
    for (int i = 0; i < n; i++) {
      String[] input = fio.nextLine().split(" ");
      Arrays.sort(input);
      list.add(String.join("", input));
    }

    for (String mods : list) {
      Integer count = frosh.get(mods);

      if (count == null) {
        count = 1;// no. of students taking unique combi
      } else {
        count++;// no. of students taking same exact combi
      }

      frosh.put(mods, count);
    }

    int maxPop = 0, num = 0;
    for (int i : frosh.values()) {
      if (i > maxPop) {
        maxPop = i;
        num = 0;
      }

      if (i == maxPop) {
        num++;
      }
    }

    fio.println(num * maxPop);
    fio.close();
  }
}
