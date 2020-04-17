import java.util.*;
import java.util.stream.IntStream;

public class SumKindOfProblem {
  public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      int p = scan.nextInt();

      for (int i = 0; i < p; i++) {
        int k = scan.nextInt();
        int n = scan.nextInt();
        int s1 = 0, s2 = 0, s3 = 0;

        s1 = (n * (n + 1)) / 2;
        s2 = n * n;
        s3 = n * n + n;

        System.out.printf("%d %d %d %d\n", k, s1, s2, s3);
      }
  }
}
