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
}

class Player {
  public int number;
  public int state;

  public Player(int number, int state) {
    this.number = number;
    this.state = state;
  }
}

public class CoconutSplat {
  public static Player(int number, int state) {
    this.number = number;
    this.state = state;
  }

  public static void main(String[] args) {
    FastIO fio = new FastIO();

    int s = fio.nextInt();
    int n = fio.nextInt();
    ArrayList<Player> players = new ArrayList<Player>();
    int index = 0;

    // fold = 1 | fist = 2 | palm = 3 | down = 4
    for (int i = 1; i <= n; i++)
       players.add(i - 1, new Player(i, 1));

    while (players.size() > 1) {
       index = (index + s - 1) % players.size();

       if (players.get(index).state == 1) {
           players.get(index).state = 2;
           players.add(index, new Player(players.get(index).number, 2));
       } else if (players.get(index).state == 2) {
           players.get(index).state = 3;
           index++;
       } else {
           players.remove(index);
       }
    }

    fio.println(players.get(0).number);
    fio.close();
  }
}
