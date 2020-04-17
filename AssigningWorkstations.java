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

class Researcher implements Comparable<Researcher> {
  public int startTime = this.startTime;
  public int leaveTime = this.leaveTime;

  public Researcher(int a, int s) {
    this.startTime = a;
    this.leaveTime = a + s;
  }

  public int compareTo(Researcher otherResearcher) {
    return this.startTime - otherResearcher.startTime;
  }
}

public class AssigningWorkstations {
  public static void main(String[] args) {
    FastIO fio = new FastIO();

    PriorityQueue<Integer> workstations = new PriorityQueue<Integer>();
    PriorityQueue<Researcher> researchers = new PriorityQueue<Researcher>();
    int n = fio.nextInt();
    int m = fio.nextInt();
    int unlock = 0;
    for (int i = 0; i < n; i++)
      researchers.add(new Researcher(fio.nextInt(), fio.nextInt()));

    for (int i = 0; i < n; i++) {
      int currTime = researchers.peek().startTime;
      while (!workstations.isEmpty()) {
        if (workstations.peek() + m < currTime) {
          workstations.poll();
        } else {
          break;
        }
      }

      if ((!workstations.isEmpty()) && ( (workstations.peek() <= researchers.peek().startTime) && (researchers.peek().startTime <= workstations.peek() + m) )) {
        unlock++;
        workstations.poll();
      }

      workstations.add(researchers.poll().leaveTime);
    }

    fio.println(unlock);
    fio.close();
  }
}
