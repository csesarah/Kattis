import java.util.*;

public class FreeFood {
  public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      int events = scan.nextInt();
      int days = 0;
      int[] cal = new int[366];
      Arrays.fill(cal, 0);

      while (events-- != 0) {
        int start = scan.nextInt();
        int end = scan.nextInt();

        for (int i = start - 1; i < end; i++) {
          cal[i] = 1;
        }
      }

      for (int i = 0; i < cal.length; i++) {
        if (cal[i] == 1) {
          days++;
        }
      }

      System.out.println(days);
  }
}
