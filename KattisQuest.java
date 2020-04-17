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

class Gold implements Comparable<Gold> {
  public int value = this.value;

  public Gold(int value) {
    this.value = value;
  }

  public int compareTo(Gold o) {
    if (this.value < o.value) {
			return 1;
		}	else if (this.value > o.value) {
			return -1;
		} else {
			return 0;
		}
  }
}

public class KattisQuest {
  public static void main(String[] args) {
    FastIO fio = new FastIO();

    int n = fio.nextInt();
    TreeMap<Integer, PriorityQueue<Gold>> quests = new TreeMap<Integer, PriorityQueue<Gold>>();

		for (int i = 0; i < n; i++) {
			String s = fio.next();
			if (s.equals("add")) {
				int e = fio.nextInt();
				int g = fio.nextInt();

				if (quests.containsKey(e)) {
					PriorityQueue<Gold> rewards = quests.get(e);
					rewards.add(new Gold(g));
					quests.put(e, rewards);
				}	else {
					PriorityQueue<Gold> rewards = new PriorityQueue<Gold>();
					rewards.add(new Gold(g));
					quests.put(e, rewards);
				}
			}	else {//s.equals("query");
				int e = fio.nextInt();
				long total = 0;

				if (quests.size() != 0) {
					while (e >= quests.firstKey() && e > 0) {
						int floorE = quests.floorKey(e);
						PriorityQueue<Gold> rewards = quests.get(floorE);
						total += rewards.poll().value;

						if (rewards.size() > 0)
							quests.put(floorE, rewards);
						else
							quests.remove(floorE);
						e -= floorE;
						if (quests.size() == 0) break;
					}
				} else {
          total = 0;
        }

				fio.println(total);
			}
    }
    fio.close();
  }
}
