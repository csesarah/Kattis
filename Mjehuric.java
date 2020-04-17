import java.util.Scanner;
import java.util.Arrays;

public class Mjehuric {
	static int[] correct = {1, 2, 3, 4, 5};

	static String print(int[] arr) {
		String printed = Arrays.toString(arr);
                printed = printed.substring(1);
                printed = printed.substring(0, printed.length() - 1);
                printed = printed.replaceAll(",", "");

		return printed;	
	}
	
	static void swap(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
					
				System.out.println(print(arr));		
			}
		}
	}

	public static void main(String[] args) {
		int[] set = {0, 0, 0, 0, 0};
		Scanner scan = new Scanner(System.in);

		for (int n = 0; n < set.length; n++) {
			set[n] = scan.nextInt();
		}

		while (!Arrays.equals(set, correct)) {
			swap(set);
		}
	}

}
