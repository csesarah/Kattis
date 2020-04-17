import java.util.*;

class DysCompare implements Comparator<String> {
  public int compare(String o1 , String o2) {
      for (int i = o1.length() - 1; i >= 0; i--)
          if (o1.charAt(i) != o2.charAt(i))
              return o1.charAt(i) - o2.charAt(i);

      return 0;
  }
}

public class Dyslectionary {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    boolean groupend = false;
    while (scan.hasNext()) {
        ArrayList<String> dict = new ArrayList<>();
        int max = 0;
        DysCompare dysComp = new DysCompare();

        while (true) {
          String word = scan.nextLine();

          if (!scan.hasNext())
              groupend = true;

          if (word.isEmpty())
              break;

          max = word.length() > max ? word.length() : max;
          dict.add(word);

          if (groupend)
              break;
        }

        for (int i = 0; i < dict.size(); i++) {
          String word = dict.get(i);
          int spaces = max - word.length();

          for (int z = 0; z < spaces; z++)
              word = " " + word;

          dict.set(i , word);
        }

        Collections.sort(dict, dysComp);

        for (String word : dict)
            System.out.println(word);

        if (!groupend)
            System.out.println();
    }
  }
}
