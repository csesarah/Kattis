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

class Person implements Comparable<Person> {
    public String name;
    public ArrayList<Integer> rank = new ArrayList<>();

    public Person(String name, String title) {
        this.name = name;

        String[] ranking = title.split("-");
        for (int i = ranking.length - 1; i >= 0; i--) {
            if (ranking[i].equals("upper")) {
                rank.add(3);
            } else if (ranking[i].equals("middle")) {
                rank.add(2);
            } else {
                rank.add(1);
            }
        }
        this.rank = rank;

        for (int i = 0; i < 10; i++) {
            rank.add(2);
        }
    }

    @Override
    public int compareTo(Person otherPerson) {
        for (int i = 0; i < 10; i++) {
            if (this.rank.get(i) == otherPerson.rank.get(i))
                continue;

            if (this.rank.get(i) > otherPerson.rank.get(i))
                return -1;

            if (this.rank.get(i) < otherPerson.rank.get(i))
                return 1;
        }

        return this.name.compareTo(otherPerson.name);
    }
}

public class AClassyProblem {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int t = fio.nextInt();
        for (int i = 0; i < t; i++) {
            int n = fio.nextInt();
            Person[] people = new Person[n];

            for (int j = 0; j < n; j++) {
                String[] line = fio.nextLine().split(" ");
                people[j] = new Person(line[0].replace(":", ""), line[1]);
            }

            Arrays.sort(people);

            for (Person indiv : people) {
                fio.println(indiv.name);
            }
            fio.println("==============================");
        }
        fio.close();
    }
}
