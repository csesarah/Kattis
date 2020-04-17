import java.util.*;

public class LostLineup {
  static class OrderComparator implements Comparator<Integer> {
    private final Integer[] array;

    public OrderComparator(Integer[] array) {
        this.array = array;
    }

    public Integer[] indexOfArray() {
        Integer[] indices = new Integer[array.length];

        for (int i = 0; i < array.length; i++) {
            indices[i] = i;
        }

        return indices;
    }

    @Override
    public int compare(Integer pos1, Integer pos2) {
        return array[pos1].compareTo(array[pos2]);
    }
  }

  public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      int n = scan.nextInt();
      Integer[] gaps = new Integer[n - 1];

      for (int i = 0; i < n - 1; i++) {
        gaps[i] = scan.nextInt();
      }

      OrderComparator orderComp = new OrderComparator(gaps);
      Integer[] people = orderComp.indexOfArray();
      Arrays.sort(people, orderComp);

      System.out.print(1 + " ");
      for (int i = 0; i < people.length; i++) {
        System.out.print(people[i] += 2);
        if (i == people.length - 1) {
          break;
        }
        System.out.print(" ");
      }

      System.out.println();
  }
}
