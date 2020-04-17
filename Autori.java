import java.util.*;

public class Autori {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String names = scan.next();

		String[] list = names.split("-");
		StringBuilder initials = new StringBuilder();

		for (String name : list) {
			name = name.substring(0, 1);
			initials.append(name);
		}

		System.out.println(initials);
	}

}
