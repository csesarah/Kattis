import java.util.Scanner;
import java.util.Arrays;

public class LineUp {

	public static void main(String[] args) {
		boolean increasing = true, decreasing = true;
		Scanner scan = new Scanner(System.in);

		int size = scan.nextInt();
		String[] list = new String[size];
	
		for (int i = 0; i < size; i++) {
			list[i] = scan.next();
		}

		for (int i = 0; i < size - 1; i++) {
			if (list[i].compareTo(list[i + 1]) > 0) {
				increasing = false;
			} else {
				decreasing = false;
			}
		}

		if (increasing) {
			System.out.println("INCREASING");
		} else if (decreasing) {
			System.out.println("DECREASING");
		} else {
			System.out.println("NEITHER");
		}
	}

}
