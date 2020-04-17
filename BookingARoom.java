import java.util.*;

public class BookingARoom {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int rooms = scan.nextInt();
		int booked = scan.nextInt();
		ArrayList<Integer> occupied = new ArrayList<Integer>(booked);

		for (int i = 0; i < booked; i++) {
			occupied.add(scan.nextInt());
		}

		if (rooms == booked) {
			System.out.println("too late");
		} else {
			Collections.sort(occupied);
			for (int i = 1; i <= rooms; i++) {
				if (!occupied.contains(i)) {
					System.out.println(i);
					break;
				}
			}
		}
	}

}
