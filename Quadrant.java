import java.util.*;

public class Quadrant {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int quad = 0;
    int x = scan.nextInt();
    int y = scan.nextInt();

    if (x > 0) {
      if (y > 0) {
        quad = 1;
      } else {
        quad = 4;
      }
    } else {
      if (y > 0) {
        quad = 2;
      } else {
        quad = 3;
      }
    }

    System.out.println(quad);
  }

}
