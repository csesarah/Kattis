import java.util.*;

public class Skener {
  public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      int r = scan.nextInt();
      int c = scan.nextInt();
      int zr = scan.nextInt();
      int zc = scan.nextInt();

      String[][] rc = new String[r][c];
      String[][] zrzc = new String[zr][zc];

      for (int i = 0; i < r; i++) {
        String row = scan.next();
        for (int j = 0; j < row.length(); j++) {
          rc[i][j] = row.substring(j, j+1);
        }
      }

      for (int i = 0; i < r; i++) {
        for (int j = 0; j < zr; j++) {
          for (int k = 0; k < c; k++) {
            for (int l = 0; l < zc; l++) {
              System.out.print(rc[i][k]);
            }
          }
          System.out.println();
        }
      }
  }
}
