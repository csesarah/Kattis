import java.util.*;

public class MoscowDream {
  public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      int a = scan.nextInt();
      int b = scan.nextInt();
      int c = scan.nextInt();
      int n = scan.nextInt();

      if (a == 0 | b == 0 | c == 0 | n < 3) {
        System.out.println("NO");
      } else {
        if (a + b + c >= n) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      }
  }
}
