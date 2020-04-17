import java.util.Scanner;

public class Statistics {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cases = 0;

		while (scan.hasNextInt()) {
			cases++;
			int min = 1000000;
			int max = -1000000;
			int size = scan.nextInt();

			for (int i = 0; i < size; i++) {
				int num = scan.nextInt();
				min = Math.min(min, num);
				max = Math.max(max, num);
			} 

			System.out.println("Case " + cases + ": " + min + " " + max + " " + (max - min));
		}
	}

}
