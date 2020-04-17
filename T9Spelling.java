import java.io.*;

public class T9Spelling {
	public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    String[] keypad = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    int n = Integer.parseInt(br.readLine());

    for (int i = 1; i <= n; i++) {
      char[] msg = br.readLine().toCharArray();
      StringBuilder nums = new StringBuilder();

      for (char letter : msg) {
        for (int j = 0; j < keypad.length; j++) {
    			int times = keypad[j].indexOf(letter);

          if (times == -1) {
            continue;
          }

          /* After first char and when previous number == current number */
          if (nums.length() > 0 && nums.charAt(nums.length() - 1) - '0' == j) {
            nums = nums.append(' ');
          }

          /* Append to output keypad number for n times where n is index of char in keypad */
          for (int k = 0; k <= times; k++) {
            nums = nums.append(j);
          }
        }
      }

      pw.printf("Case #%d: ", i);
			pw.println(nums);
		}
    pw.close();
	}
}
