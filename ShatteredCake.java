import java.util.*;

public class ShatteredCake {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int w = scan.nextInt();
    int n = scan.nextInt();
    int sumArea = 0, l = 0;

    for (int i = 0; i < n; i++) {
      int width = scan.nextInt();
      int length = scan.nextInt();
      int area = width * length;
      sumArea += area;
    }

    l = sumArea / w;
    System.out.println(l);
  }
}
