import java.util.*;

public class Mia {
  public static int[] reverse(int arr[], int size) {
    for (int i = 0; i < size / 2; i++) {
      int temp = arr[i];
      arr[i] = arr[size - i - 1];
      arr[size - i - 1] = temp;
    }

    return arr;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    while (scan.hasNextLine()) {
      int[] p1 = {scan.nextInt(), scan.nextInt()};
      int[] p2 = {scan.nextInt(), scan.nextInt()};

      if (p1[0] == 0)
        break;

      Arrays.sort(p1);
      Arrays.sort(p2);
      p1 = reverse(p1, p1.length);
      p2 = reverse(p2, p2.length);

      int set1 = Integer.parseInt(p1[0] + "" + p1[1]);
      int set2 = Integer.parseInt(p2[0] + "" + p2[1]);

      if (set1 == set2) {
        System.out.println("Tie.");
      } else if (set1 == 21 || set2 == 21) {
        if (set1 == 21) {
          System.out.println("Player 1 wins.");
        } else {
          System.out.println("Player 2 wins.");
        }
      } else if (set1 % 11 == 0 || set2 % 11 == 0) {
        if (set1 % 11 == 0 && set2 % 11 == 0) {
          if (set1 > set2) {
            System.out.println("Player 1 wins.");
          } else {
            System.out.println("Player 2 wins.");
          }
        } else if (set1 % 11 == 0) {
          System.out.println("Player 1 wins.");
        } else {
          System.out.println("Player 2 wins.");
        }
      } else {
        if (set1 > set2) {
          System.out.println("Player 1 wins.");
        } else {
          System.out.println("Player 2 wins.");
        }
      }
    }

  }
}
