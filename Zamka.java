import java.util.Scanner;

public class Zamka {

	public static boolean isEqualsX(int x, int num) {
		int sum = 0;

		while (num > 0) {
			sum += (num % 10);
			num /= 10;
		}

		if (x == sum) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int l = scan.nextInt();
		int d = scan.nextInt();
		int x = scan.nextInt();
		int n = 0, m = 0;

		for (int i = l; i < d; i++) {
			if (isEqualsX(x, i)) {
				n = i;
				break;	
			}
		}
		
		for (int j = d; j > l; j--) {
			if (isEqualsX(x, j)) {
				m = j;
				break;
			}
		}

		System.out.printf("%d\n%d\n", n, m);
	}

}
