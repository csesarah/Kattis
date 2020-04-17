import java.util.Scanner;

public class TimeLoop {
	
	public static void main(String[] args) {

		Scanner cnt = new Scanner(System.in);
		int count = cnt.nextInt();

		for (int i = 1; i < count; i++) {
			System.out.println(i + " Abracadabra");
		}
		
	}

}
