import java.util.*;

public class GrandpasCheckerboard {
  static boolean rowCorrect(char[][] board, int n) {
    boolean test = false;

    for (int r = 0; r < n; r++) {
      int black = 0;
      int white = 0;
      for (int c = 0; c < n; c++) {
        if (board[r][c] == 'B') {
          black++;
        } else {
          white++;
        }

        if (c < n - 2 && board[r][c] == board[r][c+1] && board[r][c] == board[r][c+2]) {
          return false;
        }
      }

      if (black == white) {
        test = true;
      } else {
        test = false;
        break;
      }
    }

    return test;
  }

  static boolean colCorrect(char[][] board, int n) {
    boolean test = false;

    for (int c = 0; c < n; c++) {
      int black = 0;
      int white = 0;
      for (int r = 0; r < n; r++) {
        if (board[r][c] == 'B') {
          black++;
        } else {
          white++;
        }

        if (r < n - 2 && board[r][c] == board[r+1][c] && board[r][c] == board[r+2][c]) {
          return false;
        }
      }

      if (black == white) {
        test = true;
      } else {
        test = false;
        break;
      }
    }

    return test;
  }

  public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      int n = scan.nextInt();
      char[][] board = new char[n][n];

      for (int r = 0; r < n; r++) {
          board[r] = scan.next().toCharArray();
      }

      if (rowCorrect(board, n) && colCorrect(board, n)) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }

  }
}
