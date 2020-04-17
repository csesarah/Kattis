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

public class Teque {
  public static HashMap<Integer, Integer> frontDeque = new HashMap<>();
  public static HashMap<Integer, Integer> backDeque = new HashMap<>();

  public static int frontFirst = 0, frontLast = 0, backFirst = 0, backLast = 0;

  /* PUSH-BACK */
  public static void push_back(int value) {                                     // place into last position in back half
    backDeque.put(backLast, value);
    backLast++;

    /* BALANCE */
    if (frontDeque.size() > backDeque.size()) {                                 // front half larger than back half
      frontLast--;                                                              // move last item in front half to first position in back half
      backFirst--;
      backDeque.put(backFirst, frontDeque.get(frontLast));
      frontDeque.remove(frontLast);
      return;
    } else if (backDeque.size() > frontDeque.size() + 1) {                      // back half larger than front half
      frontDeque.put(frontLast, backDeque.get(backFirst));                      // move first item in back half to last position in front half
      frontLast++;
      backFirst++;
      backDeque.remove(backFirst - 1);
      return;
    }
  }

  /* PUSH-FRONT */
  public static void push_front(int value) {                                    // place into first position in front half
    frontFirst--;
    frontDeque.put(frontFirst, value);

    /* BALANCE */
    if (frontDeque.size() > backDeque.size()) {                                 // front half larger than back half
      frontLast--;                                                              // move last item in front half to first position in back half
      backFirst--;
      backDeque.put(backFirst, frontDeque.get(frontLast));
      frontDeque.remove(frontLast);
      return;
    } else if (backDeque.size() > frontDeque.size() + 1) {                      // back half larger than front half
      frontDeque.put(frontLast, backDeque.get(backFirst));                      // move first item in back half to last position in front half
      frontLast++;
      backFirst++;
      backDeque.remove(backFirst - 1);
      return;
    }
  }

  /* PUSH-MIDDLE */
  public static void push_middle(int value) {
    if (frontDeque.size() != backDeque.size()) {                                // if queue has odd number of items
      frontDeque.put(frontLast, backDeque.get(backFirst));
      frontLast++;
      backDeque.put(backFirst, value);
    } else {                                                                    // if queue has even number of items
      backFirst--;
      backDeque.put(backFirst, value);
    }
  }


  /* GET */
  public static int get(int index) {
    if (index < frontLast - frontFirst) {                                       // if item is in first half
      return frontDeque.get(frontFirst + index);
    }

    index -= (frontLast - frontFirst);                                          // if item is in back half
    return backDeque.get(backFirst + index);
  }

  /* DRIVER */
  public static void main(String[] args) {
    FastIO fio = new FastIO();

    int n = fio.nextInt();

    for (int i = 0; i < n; i++) {
      String command = fio.next();
      int value = fio.nextInt();

      if (command.equals("push_back")) {
        push_back(value);
      } else if (command.equals("push_front")) {
        push_front(value);
      } else if (command.equals("push_middle")) {
        push_middle(value);
      } else {
        fio.println(get(value));
      }
    }

    fio.close();
  }
}
