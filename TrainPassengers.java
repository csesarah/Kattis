import java.io.*;
import java.util.*;

/**
* Fast I/O
* @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
*/
class FastIO extends PrintWriter {
   BufferedReader br;
   StringTokenizer st;

   public FastIO()
   {
       super(new BufferedOutputStream(System.out));
       br = new BufferedReader(new
               InputStreamReader(System.in));
   }

   String next()
   {
       while (st == null || !st.hasMoreElements())
       {
           try
           {
               st = new StringTokenizer(br.readLine());
           }
           catch (IOException  e)
           {
               e.printStackTrace();
           }
       }
       return st.nextToken();
   }

   int nextInt()
   {
       return Integer.parseInt(next());
   }

   long nextLong()
   {
       return Long.parseLong(next());
   }

   double nextDouble()
   {
       return Double.parseDouble(next());
   }

   String nextLine()
   {
       String str = "";
       try
       {
           str = br.readLine();
       }
       catch (IOException e)
       {
           e.printStackTrace();
       }
       return str;
   }
}

public class TrainPassengers {
  public static void main(String[] args) throws IOException {
    FastIO fio = new FastIO();
    long c = fio.nextLong();                                                // capacity of train
    int n = fio.nextInt();                                                  // no. of train stops
    boolean consistent = true;
    long train = 0;

    for (int i = 0; i < n; i++) {
      long left = fio.nextLong();                                         // passengers left train
      long enter = fio.nextLong();                                        // passengers entered train
      long stay = fio.nextLong();                                         // passengers stay at station

      if (left > train)
    		consistent = false;

    	train += enter;
      train -= left;

      /* train exceed capacity || train below 0 || passengers waited in vain || last stop & passengers still waiting */
      if (train > c || train < 0 || ((c - train > 0) && (stay > 0)) || ((i == n - 1) && stay > 0))
        consistent = false;
    }

    if (train != 0)                                                             // train still not empty after last stop
      consistent = false;

    if (consistent) {
      fio.println("possible");
    } else {
      fio.println("impossible");
    }

    fio.close();
  }
}
