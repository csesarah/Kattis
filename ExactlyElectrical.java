import java.util.*;

public class ExactlyElectrical {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int a = scan.nextInt();
    int b = scan.nextInt();
    int c = scan.nextInt();
    int d = scan.nextInt();
    int t = scan.nextInt();
    int n = 0;

    n = (Math.abs(a - c) + Math.abs(b - d));

    if ((t < n) || (t - n) % 2 != 0) {
      System.out.println("N");
    } else {
      System.out.println("Y");
    }
  }
}
