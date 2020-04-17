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

public class DelimiterSoup {
  public static void main(String[] args) {
    FastIO fio = new FastIO();

    int l = fio.nextInt();
    char[] input = fio.nextLine().toCharArray();
    Stack<Character> line = new Stack<Character>();

    for (int i = 0; i < l; i++) {
      char c = input[i];

      if (c == ')' || c == ']' || c == '}') {                                   // if close bracket
        if (line.empty()) {                                                     // if too many opening brackets
          fio.println(c + " " + i);
          fio.close();
          break;
        } else {
          char check = ' ';
          if (c == ')') {
            check = '(';
          } else if (c == ']') {
            check = '[';
          } else if (c == '}') {
            check = '{';
          }


          if (line.pop() != check) {                                            // if doesnt match
            fio.println(c + " " + i);
            fio.close();
            break;
          }
        }
      } else if (c == ' ') {                                                    // if space char, continue
        continue;
      } else {                                                                  // if open bracket, push onto stack
        line.push(c);
      }
    }

    fio.println("ok so far");

    fio.close();
  }
}
