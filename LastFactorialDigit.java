import java.util.*;

public class LastFactorialDigit {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();

    for (int i = 0; i < t; i++) {
      int n = scan.nextInt();

      if (n == 1) {
        System.out.println("1");
      } else if (n == 2) {
        System.out.println("2");
      } else if (n == 3) {
        System.out.println("6");
      } else if (n == 4) {
        System.out.println("4");
      } else {
        System.out.println("0");
      }
    }

  }

}
