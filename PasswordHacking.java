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

class Password {
  public String password;
  public double prob;

  public Password(String password, double prob) {
    this.password = password;
    this.prob = prob;
  }

  public String getPassword() {
    return password;
  }

  public double getProb() {
    return prob;
  }
}

class CompareProbability implements Comparator<Password> {
    public int compare(Password p1, Password p2) {
      if (p1.getProb() < p2.getProb()) {
        return 1;
      } else if (p1.getProb() > p2.getProb()) {
        return -1;
      } else {
        return 0;
      }
    }

    public boolean equals(Object obj) {
      return this == obj;
    }
}

public class PasswordHacking {
  public static void main(String[] args) {
    FastIO scan = new FastIO();

    int n = scan.nextInt();
    CompareProbability probComp = new CompareProbability();
    ArrayList<Password> pwlist = new ArrayList<>();
    double tries = 0.0;
    int count = 0;

    for (int i = 0; i < n; i++) {
      pwlist.add(new Password(scan.next(), scan.nextDouble()));
    }

    Collections.sort(pwlist, probComp);

    for (Password w : pwlist) {
      tries += w.prob * (count++ + 1);
    }

    System.out.println(tries);
  }
}
