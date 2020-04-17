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

    double nextDouble() {
        return Double.parseDouble(next());
    }
}

class Runner implements Comparable<Runner>{
  public String name;
  public double firstLeg;
  public double nthLeg;

  public Runner(String name, double firstLeg, double nthLeg) {
    this.name = name;
    this.firstLeg = firstLeg;
    this.nthLeg = nthLeg;
  }

  public int compareTo(Runner otherRunner) {
    if (this.nthLeg < otherRunner.nthLeg)
      return -1;

    if (this.nthLeg > otherRunner.nthLeg)
      return 1;

    return 0;
  }
}

public class BestRelayTeam {
  public static void main(String[] args) {
    FastIO fio = new FastIO();

    int n = fio.nextInt();
    Runner[] runners = new Runner[n];
    double fastest = Double.MAX_VALUE;
    ArrayList<Integer> team = new ArrayList<Integer>();

    for (int i = 0; i < n; i++)
			runners[i] = new Runner(fio.next(), fio.nextDouble(), fio.nextDouble());

		Arrays.sort(runners);

		for (int i = 0; i < n; i++) {
			double time = runners[i].firstLeg;
			ArrayList<Integer> currTeam = new ArrayList<Integer>();
			currTeam.add(i);

			for (int j = 0; currTeam.size() < 4; j++) {
				currTeam.add(j);
				time += runners[j].nthLeg;
			}

			if (time < fastest) {
				fastest = time;
				team = currTeam;
			}
		}

		fio.println(fastest);
		for (int i = 0; i < 4; i++)
			fio.println(runners[team.get(i)].name);

    fio.close();
  }
}
