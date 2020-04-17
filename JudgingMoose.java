import java.util.Scanner;

public class JudgingMoose {

	public static void main(String[] args) {
		
		Scanner left = new Scanner(System.in);
		int l = left.nextInt();

		Scanner right = new Scanner(System.in);
		int r = left.nextInt();	
			
		if (l == 0 && r == 0) {
			System.out.println("Not a moose");
		} else if ((l + r) % 2 == 0 ) {
			System.out.printf("Even %d\n" ,l + r);	
		} else {
			if (l > r) {
				System.out.printf("Odd %d\n", 2 * l);
			} else {
				System.out.printf("Odd %d\n", 2 * r);
			}
		}

	}

}
