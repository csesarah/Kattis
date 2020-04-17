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

public class WhatDoesTheFoxSay {
  public static void main(String[] args) {
    FastIO fio = new FastIO();

    int t = fio.nextInt();
    for (int i = 0; i < t; i++) {
      HashMap<String, String> animals = new HashMap<String, String>();
      ArrayList<String> fox = new ArrayList<String>();
      String[] sounds = fio.nextLine().split(" ");
      while (true) {
        String in = fio.nextLine();
        if (in.equals("what does the fox say?")) break;
        String[] animalSound = in.split(" ");

        animals.put(animalSound[2], animalSound[0]);
      }

      for (int j = 0; j < sounds.length; j++) {
        if (animals.get(sounds[j]) == null) {
          fox.add(sounds[j]);
        }
      }

      int j = 0;
      for (String foxNoise : fox) {
        fio.print(foxNoise);
        if (j == fox.size() - 1) {
          fio.print("\n");
        } else {
          fio.print(" ");
        }
        j++;
      }
    }

    fio.close();
  }
}
