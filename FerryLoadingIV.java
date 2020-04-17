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

public class FerryLoadingIV {
  public static void main(String[] args) {
    FastIO fio = new FastIO();

    int c = fio.nextInt();

    for (int i = 0; i < c; i++) {
      int l = fio.nextInt() * 100;
      int m = fio.nextInt();
      Queue<Integer> left = new LinkedList<>();
      Queue<Integer> right = new LinkedList<>();
      int times = 0;

      for (int j = 0; j < m; j++) {
        int car = fio.nextInt();
        String side = fio.next();
        if (side.equals("left")) {
          left.add(car);
        } else {
          right.add(car);
        }
      }

      String currSide = "left";
      while (!left.isEmpty() || !right.isEmpty()) {
        int ferry = l;
        if (currSide == "left") {
          while (!left.isEmpty()) {
            if (ferry - left.peek() >= 0) {
              ferry -= left.poll();
            } else {
              break;
            }
          }
          currSide = "right";
        } else if (currSide == "right") {
          while (!right.isEmpty()) {
            if (ferry - right.peek() >= 0) {
              ferry -= right.poll();
            } else {
              break;
            }
          }
          currSide = "left";
        }
        times++;
      }

      fio.println(times);
    }

    fio.close();
  }
}
