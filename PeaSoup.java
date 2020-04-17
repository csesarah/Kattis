import java.util.*;

public class PeaSoup {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		while(n-- > 0) {
			int k = scan.nextInt();
			scan.nextLine();
			String restaurant = scan.nextLine();
			boolean peas = false, panc = false;

			while(k-- > 0 && !(peas && panc)) {
				String line = scan.nextLine();
				if (line.equals("pea soup"))
					peas = true;
				else if (line.equals("pancakes")) {
					panc = true;
				}
			}

			if (peas && panc) {
				System.out.println(restaurant);
				System.exit(0);
			}
		}
		System.out.println("Anywhere is fine I guess");
	}

}
