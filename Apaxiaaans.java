import java.util.*;

public class Apaxiaaans {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String apaxian = scan.next();
    char[] apax = (apaxian + " ").toCharArray();
    String name = "";

    for (int i = 0; i < apax.length - 1; i++) {
      if (apax[i] != apax[i + 1]) {
        name += apax[i];
      }
    }

    System.out.println(name);
  }
}
