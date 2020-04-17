import java.util.*;

public class RaggedRight {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    ArrayList<Integer> lines = new ArrayList<>();
    int n = 0, penalty = 0;

    while(scan.hasNextLine())
        lines.add(scan.nextLine().length());

    n = Collections.max(lines);

    for (int i = 0; i < lines.size() - 1; i++)
      penalty += (n - lines.get(i)) * (n - lines.get(i));

    System.out.println(penalty);
  }

}
