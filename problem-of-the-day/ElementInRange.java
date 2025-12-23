import java.util.ArrayList;
import java.util.Arrays;

public class ElementInRange {

  public static void main(String[] args) {
    ElementInRange eir = new ElementInRange();
    
    int[] arr = { 20, 36, 33, 55, 35, 36, 27, 1, 32, 44, 43, 2, 13 };
    int[][] queries = {
        { 45, 49 },
        { 15, 38 },
        { 3, 61 },
        { 9, 29 },
        { 36, 38 },
        { 44, 52 },
        { 4, 16 }
    };
    var al = eir.cntInRange(arr, queries);
    System.out.println(al);


  }

  public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
    // code here
    Arrays.sort(arr);
    ArrayList<Integer> al = new ArrayList<>();
    for (int[] q : queries) {
      al.add(getCountInRange(arr, q[0], q[1]));
    }
    return al;
  }

  private int getCountInRange(int[] arr, int from, int to) {

    if (arr[arr.length - 1] < from || arr[0] > to)
      return 0;

    int low = 0;
    int high = arr.length - 1;
    int startIndex = -1;
    int endIndex = -1;

    // start index
    if (arr[0] >= from)
      startIndex = 0;
    else {
      while (high >= low) {
        int mid = (low + high) / 2;
        if (mid == 0 && arr[mid] == from) {
          startIndex = mid;
          break;
        }

        if ((arr[mid] == from && arr[mid - 1] != from) || (arr[mid] > from && arr[mid - 1] < from)) {
          startIndex = mid;
          break;
        }
        if (arr[mid] >= from)
          high = mid - 1;
        else
          low = mid + 1;
      }
    }

    System.out.println(startIndex);

    low = 0;
    high = arr.length - 1;

    // end index
    if (arr[arr.length - 1] <= to)
      endIndex = arr.length - 1;
    else {
      while (high >= low) {
        int mid = (low + high) / 2;
        if (mid == arr.length - 1 && arr[mid] == from) {
          startIndex = mid;
          break;
        }

        if ((arr[mid] == to && arr[mid + 1] != to) || (arr[mid] < to && arr[mid + 1] > to)) {
          endIndex = mid;
          break;
        }
        if (arr[mid] >= to)
          high = mid - 1;
        else
          low = mid + 1;
      }
    }
    System.out.println(endIndex);

    return endIndex - startIndex + 1;
  }
}
